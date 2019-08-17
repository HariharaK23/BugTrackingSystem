package com.bugtracker.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bugtracker.model.Bug;
import com.bugtracker.service.UserService;

@Controller
public class UpdateController {
	
	@Autowired
	public UserService userService;
	
	@RequestMapping(value = "/UpdateBugProcess", method = RequestMethod.POST)
	public ModelAndView updateBug(@ModelAttribute("bug") Bug bug,HttpSession session) {
		ModelAndView mav = null;
		String name=(String) session.getAttribute("emp_name");
		Boolean ret=userService.updateBug(bug,name);
		if (ret) {
			mav = new ModelAndView("TestingTeam");
			mav.addObject("message", "DONE");
		} else {
			mav = new ModelAndView("TestingTeam");
			mav.addObject("message", "ERROR");
		}
		return mav;
	}

}
