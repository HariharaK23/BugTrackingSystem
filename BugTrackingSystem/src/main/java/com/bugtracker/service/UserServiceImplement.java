package com.bugtracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bugtracker.dao.UserDao;
import com.bugtracker.model.Admin;
import com.bugtracker.model.Bug;
import com.bugtracker.model.Employee;
import com.bugtracker.model.Login;
import com.bugtracker.model.Project;

public class UserServiceImplement implements UserService{
	
	@Autowired
	public UserDao userDao;

	@Override
	public Admin validateAdmin(Login login) {
		return userDao.validateAdmin(login);
	}

	@Override
	public Employee validateEmployee(Login login) {
		return userDao.validateEmployee(login);
	}

	@Override
	public List<Employee> showEmployees() {
		return userDao.showEmployees();
	}

	@Override
	public Boolean addBug(Bug bug) {
		return userDao.addBug(bug);
	}

	@Override
	public Boolean updateBug(Bug bug,String name) {
		return userDao.updateBug(bug,name);
	}

	@Override
	public List<Bug> showTesterBugs(String name) {
		return userDao.showTesterBugs(name);
	}

	@Override
	public List<Bug> showAllBugs() {
		return userDao.showAllBugs();
	}

	@Override
	public List<Bug> showMyBugs(String name) {
		return userDao.showMyBugs(name);
	}

	@Override
	public Boolean addProject(Project project,String manager) {
		return userDao.addProject(project,manager);
	}

}
