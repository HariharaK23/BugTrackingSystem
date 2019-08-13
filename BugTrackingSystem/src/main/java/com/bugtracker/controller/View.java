package com.bugtracker.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.bugtracker.service.ViewService;

@Controller
public class View {
	ViewService viewService= new ViewService();
	@RequestMapping(value = "/showEmployee")
	public ModelAndView viewEmployee(ModelAndView model) throws IOException {
		try {
		List emp = viewService.viewEmployee();
		System.out.println(emp);
		model.addObject("emp", emp);
		model.setViewName("showEmployee");
		}catch(Exception e) {
			System.out.println("NULL HERE");
		}
		return model;
	}
	
	@RequestMapping(value = "/admin")
	public String addEmployee(Model model) {
		return "admin";
		
	}
	@RequestMapping(value = "/showAllBugs")
	public ModelAndView showBugs(ModelAndView model) throws IOException {
		try {
		List bugs = viewService.showBugs();
		System.out.println(bugs);
		model.addObject("bugs", bugs);
		model.setViewName("showAllBugs");
		}catch(Exception e) {
			System.out.println("NULL HERE");
		}
		return model;
	}

}
