package com.bugtracker.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bugtracker.model.Admin;
import com.bugtracker.model.Bug;
import com.bugtracker.model.Employee;
import com.bugtracker.model.Login;
import com.bugtracker.model.Project;


@Repository
public interface UserDao {
	
	Admin validateAdmin(Login login);
	Employee validateEmployee(Login login);
	List<Employee> showEmployees();
	Boolean addBug(Bug bug);
	Boolean updateBug(Bug bug,String name);
	List<Bug> showTesterBugs(String name);
	List<Bug> showAllBugs();
	List<Bug> showMyBugs(String name);
	Boolean addProject(Project project,String manager);

}
