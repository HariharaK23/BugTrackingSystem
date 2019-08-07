package com.bugtracker.service;

import java.util.Arrays;
import java.util.List;


import com.bugtracker.dao.ViewDao;
import com.bugtracker.model.Employee;

public class ViewService{
	
	ViewDao viewDao = new ViewDao();
	
//Arrays.toString(list.toArray())
	public List viewEmployee() {
		return viewDao.getAllEmployee();
		
	}

	public List showBugs() {
		
		return viewDao.getAllBugs();
	}
		
	}

