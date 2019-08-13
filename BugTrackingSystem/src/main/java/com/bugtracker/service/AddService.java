package com.bugtracker.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.bugtracker.dao.AddDao;
import com.bugtracker.model.Employee;

public class AddService {
	
	final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	final static String DB_URL = "jdbc:mysql://localhost:3306/bug_ tracking_system";
	final static String USER = "root";
	final static String PASS = "";
	static Connection conn= null;
	public static boolean addEmployees(Employee employee) {
		
			try {
				Class.forName(JDBC_DRIVER);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			try {
				conn = DriverManager.getConnection(DB_URL, USER, PASS);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if (AddDao.addEmployee(conn,employee)) {
			return true;
		}
		return false;
	}

	public static boolean updateEmployee(Employee employee) {

		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (AddDao.updateEmployee(conn,employee)) {
			return true;}
		return false;
	}

	public static boolean removeEmployee(Employee employee) {
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (AddDao.removeEmployee(conn,employee)) {
			return true;
		}
		return false;
	}

}
