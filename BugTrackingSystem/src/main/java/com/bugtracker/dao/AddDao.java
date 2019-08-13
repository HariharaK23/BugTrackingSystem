package com.bugtracker.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import com.bugtracker.model.Employee;

public class AddDao {

	public static boolean addEmployee(Connection conn,Employee employee) {
		
		Statement statement = null;
		try {
			String email=employee.getEmployeeEmail();
			String password=employee.getEmployeePassword();
			statement = (Statement) conn.createStatement();
			String sql = "INSERT INTO employee(emp_email,emp_pwd) VALUES ('"+email+"','"+password+"')";
			statement.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	public static boolean removeEmployee(Connection conn,Employee employee) {
		Statement statement = null;
		try {
			String email=employee.getEmployeeEmail();
			statement = (Statement) conn.createStatement();
			String sql = "DELETE FROM employee where emp_email='"+email+"'";
			statement.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	public static boolean updateEmployee(Connection conn,Employee employee) {
		Statement statement = null;
		try {
			
			System.out.println("came here for update");
			String email=employee.getEmployeeEmail();
			String name=employee.getEmployeeName();
			String password=employee.getEmployeePassword();
			System.out.println(password);
			Long phone=employee.getEmployeePhone();
			statement = (Statement) conn.createStatement();
			String sql = "UPDATE employee set emp_name='"+name+"',emp_pwd='"+password+"',phone="+phone+" where emp_email='"+email+"'";
			statement.execute(sql);
			System.out.println("came here after update");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
		
		
	}

}
