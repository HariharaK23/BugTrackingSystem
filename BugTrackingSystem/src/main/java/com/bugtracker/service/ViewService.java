package com.bugtracker.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import com.bugtracker.dao.ViewDao;
import com.bugtracker.model.Employee;

public class ViewService {

	ViewDao viewDao = new ViewDao();
	final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	final String DB_URL = "jdbc:mysql://localhost:3306/bug_ tracking_system";
	final String USER = "root";
	final String PASS = "";
	Connection conn = null;

	public List viewEmployee() {

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
		return viewDao.getAllEmployee(conn);

	}

	public List showBugs() {
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
		return viewDao.getAllBugs(conn);
	}

}
