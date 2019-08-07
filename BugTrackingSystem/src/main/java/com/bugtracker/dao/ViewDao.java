package com.bugtracker.dao;

import java.io.PrintStream;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import com.bugtracker.model.Bugs;
import com.bugtracker.model.Employee;
import com.bugtracker.model.Login;
import com.bugtracker.model.User;

public class ViewDao{

	public List getAllEmployee() {
		
		
		List list2= new ArrayList();
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://localhost:3306/bug_ tracking_system";
		final String USER = "root";
		final String PASS = "";

			java.sql.Connection conn = null;
			try {
				// STEP 1: Register JDBC driver
				Class.forName(JDBC_DRIVER);

				// STEP 2: Open a connection
				System.out.println("Connecting to database...");
				
				conn = DriverManager.getConnection(DB_URL, USER, PASS);
				
				// STEP 3: Execute a query
				System.out.println("Connected database successfully...");
			}catch (Exception e) {
				System.out.println("ex here");
			}

			Statement statement = null;
			try {
				statement = (Statement) conn.createStatement();
				String sql = "SELECT * from employee";
				ResultSet rs = statement.executeQuery(sql);
				// STEP 4: Extract data from result set
				while (rs.next()) {
					List list = new ArrayList();
					Employee emp = new Employee();
					emp.setEmployeeEmail(rs.getString("emp_email"));
					emp.setEmployeeName(rs.getString("emp_name"));
					emp.setEmployeePassword(rs.getString("emp_pwd"));
					emp.setEmployeeDesignation(rs.getString("emp_designation"));
					emp.setEmployeeProjectId(rs.getInt("emp_projectId"));
					emp.setEmployeePhone(rs.getLong("phone"));
					list.add(emp.getEmployeeEmail());
					list.add(emp.getEmployeePassword());
					list.add(emp.getEmployeeName());
					list.add(emp.getEmployeeDesignation());
					list.add(emp.getEmployeeProjectId());
					list.add(emp.getEmployeePhone());
					list2.add(list);
					
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list2;
	}

	public List getAllBugs() {
		List list3= new ArrayList();
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://localhost:3306/bug_ tracking_system";
		final String USER = "root";
		final String PASS = "";

			java.sql.Connection conn = null;
			try {
				// STEP 1: Register JDBC driver
				Class.forName(JDBC_DRIVER);

				// STEP 2: Open a connection
				System.out.println("Connecting to database...");
				
				conn = DriverManager.getConnection(DB_URL, USER, PASS);
				
				// STEP 3: Execute a query
				System.out.println("Connected database successfully...");
			}catch (Exception e) {
				System.out.println("ex here");
			}

			Statement statement = null;
			try {
				statement = (Statement) conn.createStatement();
				String sql = "SELECT * from bugs";
				ResultSet rs = statement.executeQuery(sql);
				// STEP 4: Extract data from result set
				while (rs.next()) {
					List list4 = new ArrayList();
					Bugs bugs= new Bugs();
					bugs.setBug_name(rs.getString("bug_name"));
					bugs.setBug_projectId(rs.getInt("bug_projectId"));
					bugs.setBug_developerName(rs.getString("bug_developerName"));
					bugs.setBug_testerName(rs.getString("bug_testerName"));
					bugs.setBug_statusId(rs.getInt("bug_statusId"));
					bugs.setSolution(rs.getString("solution"));
					list4.add(bugs.getBug_name());
					list4.add(bugs.getBug_projectId());
					list4.add(bugs.getBug_developerName());
					list4.add(bugs.getBug_testerName());
					list4.add(bugs.getBug_statusId());
					list4.add(bugs.getSolution());
					list3.add(list4);
					
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list3;
	}
	
	}
