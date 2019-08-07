package com.bugtracker.service;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bugtracker.dao.UserDao;
import com.bugtracker.dao.UserDaoImpl;
import com.bugtracker.model.Login;
import com.bugtracker.model.User;

import com.bugtracker.dao.UserDaoImpl;
import com.bugtracker.model.Login;
import com.sun.corba.se.pept.transport.Connection;

@Service
public class UserServiceImpl {

	UserDaoImpl userDaoImpl = new UserDaoImpl();

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/bug_ tracking_system";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "";

	public boolean loginValidation(Login login) {

		java.sql.Connection conn = null;
		try {
			// STEP 1: Register JDBC driver
			Class.forName(JDBC_DRIVER);

			// STEP 2: Open a connection
			System.out.println("Connecting to database...");
			
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			
			// STEP 3: Execute a query
			System.out.println("Connected database successfully...");

			if (userDaoImpl.loginValidate(conn, login)) {
				return true;
			}

			// Display values
//	            System.out.print("ID: " + id); 
//	            System.out.print(", Age: " + age); 
//	            System.out.print(", First: " + first); 
//	            System.out.println(", Last: " + last); 

			// STEP 5: Clean-up environment

		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try

		return false;
	}
	public boolean emploginValidation(Login login) {

		java.sql.Connection conn = null;
		try {
			// STEP 1: Register JDBC driver
			Class.forName(JDBC_DRIVER);

			// STEP 2: Open a connection
			System.out.println("Connecting to database...");
			
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			
			// STEP 3: Execute a query
			System.out.println("Connected database successfully...");

			if (userDaoImpl.emploginValidate(conn, login)) {
				return true;
			}

			// Display values
//	            System.out.print("ID: " + id); 
//	            System.out.print(", Age: " + age); 
//	            System.out.print(", First: " + first); 
//	            System.out.println(", Last: " + last); 

			// STEP 5: Clean-up environment

		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try

		return false;
	}

}