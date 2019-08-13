package com.bugtracker.service;

import java.sql.DriverManager;
import java.sql.SQLException;
import org.springframework.stereotype.Service;
import com.bugtracker.dao.UserDaoImpl;
import com.bugtracker.model.Login;

@Service
public class UserServiceImpl {

	UserDaoImpl userDaoImpl = new UserDaoImpl();
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/bug_ tracking_system";
	static final String USER = "root";
	static final String PASS = "";

	public boolean loginValidation(Login login) {

		java.sql.Connection conn = null;
		try {
			Class.forName(JDBC_DRIVER);	
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			if (userDaoImpl.loginValidate(conn, login)) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		return false;
	}
	public boolean emploginValidation(Login login) {

		java.sql.Connection conn = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			if (userDaoImpl.emploginValidate(conn, login)) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return false;
	}

}