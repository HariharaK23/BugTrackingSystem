package com.bugtracker.service;

import com.bugtracker.dao.AddDao;
import com.bugtracker.model.Employee;

public class AddService {

	public static boolean addEmployee(Employee employee) {
		if (AddDao.addEmployee(employee)) {
			return true;
		}
		return false;
	}

	public static boolean updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return false;
	}

}
