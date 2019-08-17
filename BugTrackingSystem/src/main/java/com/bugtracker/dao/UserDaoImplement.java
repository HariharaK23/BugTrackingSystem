package com.bugtracker.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.bugtracker.model.Admin;
import com.bugtracker.model.Bug;
import com.bugtracker.model.Employee;
import com.bugtracker.model.Login;
import com.bugtracker.model.Project;

public class UserDaoImplement implements UserDao {

	@Autowired
	DataSource datasource;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public Admin validateAdmin(Login login) {
		String sql = "Select * from admin where adminemail='" + login.getUsername() + "' " + "and adminpassword='"
				+ login.getPassword() + "'";
		
		List<Admin> admin= jdbcTemplate.query(sql, new AdminMapper());
		return admin.size()>0?admin.get(0):null;
	}
	
	

	@Override
	public Employee validateEmployee(Login login) {
		String sql = "Select * from employee where emp_email='" + login.getUsername() + "' " + "and emp_password='"
				+ login.getPassword() + "'";
		List<Employee> employee= jdbcTemplate.query(sql, new EmployeeMapper());
		return employee.size()>0?employee.get(0):null;
	
	}



	@Override
	public List<Employee> showEmployees() {
		String sql = "Select * from employee";
		List<Employee> employee= jdbcTemplate.query(sql, new EmployeeMapper());
		return employee;
	}



	@Override
	public Boolean addBug(Bug bug) {
		String solution="NA";
		String sql = "insert into bug values('"+bug.getBugName()+"','"+bug.getBugCoder()+"','"+bug.getBugTester()+"','"+bug.getBugProject()+"','"+bug.getBugStatus()+"','"+solution+"')";
		jdbcTemplate.execute(sql);
		return true;
	}



	@Override
	public Boolean updateBug(Bug bug,String name) {
		String sql="update bug set bug_status='"+bug.getBugStatus()+"' where bug_tester='"+name+"'" ;
		jdbcTemplate.execute(sql);
		return true;
	}

@Override
	public List<Bug> showTesterBugs(String name) {
		String sql = "Select * from bug where bug_tester='"+name+"'";
		List<Bug> Testerbugs=jdbcTemplate.query(sql, new BugMapper());
		return Testerbugs;
	}



@Override
public List<Bug> showAllBugs() {
	String sql = "Select * from bug";
	List<Bug> bugs=jdbcTemplate.query(sql, new BugMapper());
	return bugs;
	
}



@Override
public List<Bug> showMyBugs(String name) {
	String sql = "Select * from bug where bug_coder='"+name+"'";
	List<Bug> Coderbugs=jdbcTemplate.query(sql, new BugMapper());
	return Coderbugs;
	
}



@Override
public Boolean addProject(Project project,String manager) {
	String sql = "insert into project values('"+project.getProjectId()+"','"+project.getProjectName()+"','"+manager+"')";
	jdbcTemplate.execute(sql);
	return true;
}




}
class AdminMapper implements RowMapper{
	 public Admin mapRow(ResultSet rs, int arg1) throws SQLException {
		    Admin admin = new Admin();
		    admin.setAdminEmail(rs.getString("adminemail"));
		    admin.setAdminPassword(rs.getString("adminpassword"));
		    return admin;
		  }
}

class EmployeeMapper implements RowMapper{
	public Employee mapRow(ResultSet rs, int arg1) throws SQLException {
	    Employee employee = new Employee();
	   employee.setEmployeeEmail(rs.getString("emp_email"));
	   employee.setEmployeePassword(rs.getString("emp_password"));
	   employee.setEmployeeName(rs.getString("emp_name"));
	   employee.setEmployeeDesignation(rs.getString("emp_designation"));
	   employee.setEmployeePhone(rs.getLong("emp_phone"));
	   employee.setEmployeeProjectId(rs.getInt("emp_projectId"));
	    return employee;
	  }
}

class BugMapper implements RowMapper{
	public Bug mapRow(ResultSet rs, int arg1) throws SQLException {
	    Bug Testerbugs = new Bug();
	   Testerbugs.setBugName(rs.getString("bug_name"));
	   Testerbugs.setBugCoder(rs.getString("bug_coder"));
	   Testerbugs.setBugTester(rs.getString("bug_tester"));
	   Testerbugs.setBugProject(rs.getString("bug_project"));
	   Testerbugs.setBugStatus(rs.getString("bug_status"));
	   Testerbugs.setBugSolution(rs.getString("bug_solution"));
	    return Testerbugs;
	  }
}
