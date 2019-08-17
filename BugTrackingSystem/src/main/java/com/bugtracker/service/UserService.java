package com.bugtracker.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bugtracker.model.Admin;
import com.bugtracker.model.Bug;
import com.bugtracker.model.Login;
import com.bugtracker.model.Project;
import com.bugtracker.model.Employee;;


@Service
public interface UserService {
	
	Admin validateAdmin(Login login);
	Employee validateEmployee(Login login);
	List<Employee> showEmployees();
	Boolean addBug(Bug bug);
	Boolean updateBug(Bug bug,String name);
	List<Bug> showTesterBugs(String name);
	List<Bug> showAllBugs();
	List<Bug> showMyBugs(String name);
	Boolean addProject(Project project,String manager);

}
