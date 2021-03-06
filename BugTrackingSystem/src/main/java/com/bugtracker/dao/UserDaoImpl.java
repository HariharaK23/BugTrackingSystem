package com.bugtracker.dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.springframework.stereotype.Repository;

import com.bugtracker.model.Login;

@Repository
public class UserDaoImpl {

	public boolean loginValidate(Connection conn, Login login) {
		Statement statement = null;
		try {
			statement = (Statement) conn.createStatement();
			String sql = "SELECT admin_id, admin_password from admin";
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String id = rs.getString("admin_id");
				String password = rs.getString("admin_password");
				if ((login.getUsername()).equals(id) && (login.getPassword()).equals(password)) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
	public boolean emploginValidate(Connection conn, Login login) {
		Statement statement = null;
		try {
			statement = (Statement) conn.createStatement();
			String sql = "SELECT emp_email, emp_pwd from employee";
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String id = rs.getString("emp_email");
				String password = rs.getString("emp_pwd");
				if ((login.getUsername()).equals(id) && (login.getPassword()).equals(password)) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
}