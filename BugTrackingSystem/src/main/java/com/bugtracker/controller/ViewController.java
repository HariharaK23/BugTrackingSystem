package com.bugtracker.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bugtracker.model.Bug;
import com.bugtracker.model.Employee;
import com.bugtracker.model.Project;
import com.bugtracker.service.UserService;

@Controller
public class ViewController {
	
	@Autowired
	public UserService userService;
	
	@RequestMapping(value = "/ShowEmployees")
	public ModelAndView viewEmployee(ModelAndView mav)  {
		List<Employee> employees= userService.showEmployees();
		System.out.println(employees);
		mav.addObject("employees", employees);
		mav.setViewName("ShowEmployees");
		return mav;
	}
	
	@RequestMapping(value = "/AddEmployee")
	public ModelAndView addEmployee(ModelAndView mav)  {
		mav.setViewName("AddEmployee");
		return mav;
	}
	
	@RequestMapping(value = "/AddBug")
	public ModelAndView addBug()  {
		ModelAndView mav = new ModelAndView("AddBug");
		mav.addObject("bug", new Bug());
		return mav;
	}
	
	@RequestMapping(value = "/UpdateBug")
	public ModelAndView updateBug(ModelAndView mav,HttpSession session)  {
		String name=(String) session.getAttribute("emp_name");
		List<Bug> Testerbugs= userService.showTesterBugs(name);
		System.out.println(Testerbugs);
		mav.addObject("Testerbugs", Testerbugs);
		mav.addObject("bug", new Bug());
		mav.setViewName("UpdateBug");
		return mav;
	}
	
	@RequestMapping(value = "/ShowAllBugs")
	public ModelAndView showAllBugs(ModelAndView mav)  {
		List<Bug> bugs= userService.showAllBugs();
		mav.addObject("bugs",bugs);
		mav.setViewName("ShowBugs");
		return mav;
	}
	
	@RequestMapping(value = "/ShowMyBugs")
	public ModelAndView shoMyBugs(ModelAndView mav,HttpSession session)  {
		String name=(String) session.getAttribute("emp_name");
		List<Bug> Coderbugs= userService.showMyBugs(name);
		mav.addObject("bugs",Coderbugs);
		mav.setViewName("ShowBugs");
		return mav;
	}
	
	@RequestMapping(value = "/AddProject")
	public ModelAndView addProject()  {
		ModelAndView mav = new ModelAndView("AddProject");
		mav.addObject("project", new Project());
		return mav;
	}
	
	
}
