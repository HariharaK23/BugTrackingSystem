package com.bugtracker.dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bugtracker.model.Employee;

public class AddDao {

	public static boolean addEmployee(Employee employee) {
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
		} catch (Exception e) {
			System.out.println("ex here");
		}

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
		return true;
	}

}
