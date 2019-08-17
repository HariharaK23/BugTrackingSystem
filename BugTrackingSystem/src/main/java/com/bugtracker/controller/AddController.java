package com.bugtracker.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bugtracker.model.Bug;
import com.bugtracker.model.Project;
import com.bugtracker.service.UserService;

@Controller
public class AddController {

	@Autowired
	public UserService userService;
	
	@RequestMapping(value = "/AddBugProcess", method = RequestMethod.POST)
	public ModelAndView AddBugProcess(@ModelAttribute("bug") Bug bug) {
		ModelAndView mav = null;
		Boolean ret=userService.addBug(bug);
		if (ret) {
			mav = new ModelAndView("TestingTeam");
			mav.addObject("message", "DONE");
		} else {
			mav = new ModelAndView("TestingTeam");
			mav.addObject("message", "ERROR");
		}
		return mav;
	}
	

	@RequestMapping(value = "/AddProjectProcess", method = RequestMethod.POST)
	public ModelAndView AddProjectProcess(@ModelAttribute("project") Project project,HttpSession session) {
		ModelAndView mav = null;
		String manager=(String) session.getAttribute("emp_name");
		Boolean ret=userService.addProject(project,manager);
		if (ret) {
			mav = new ModelAndView("Managers");
			mav.addObject("message", "DONE");
		} else {
			mav = new ModelAndView("TestingTeam");
			mav.addObject("message", "ERROR");
		}
		return mav;
	}

}
