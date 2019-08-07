package com.bugtracker.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bugtracker.model.Login;
import com.bugtracker.service.UserServiceImpl;


@Controller
public class LoginController {

	UserServiceImpl userServiceImpl = new UserServiceImpl();

	@RequestMapping(value = "/login")
	public String login(Model model) {
		Login login = new Login();
		model.addAttribute("login", login);
		return "login";
	}
	@RequestMapping(value = "/emplogin")
	public String emplogin(Model model) {
		Login login = new Login();
		model.addAttribute("login", login);
		return "employeelogin";
	}

	@RequestMapping(value = "/adminlog", method = RequestMethod.POST)
	public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse httpServletResponse,
			@ModelAttribute("login") Login login) {
		ModelAndView modelAndView;
		System.out.println(login.getUsername() + " " + login.getPassword());

		if (userServiceImpl.loginValidation(login)) {
			modelAndView = new ModelAndView("admin");
		} else {
			modelAndView = new ModelAndView("login");
			modelAndView.addObject("message", "INVALID USERNAME OR PASSWORD");
		}

		return modelAndView;
	}
	
	@RequestMapping(value = "/employeelog", method = RequestMethod.POST)
	public ModelAndView emploginProcess(HttpServletRequest request, HttpServletResponse httpServletResponse,
			@ModelAttribute("login") Login login) {
		ModelAndView modelAndView;
		System.out.println("COMING HERE");
		if (userServiceImpl.emploginValidation(login)) {
			modelAndView = new ModelAndView("employee");
		} else {
			modelAndView = new ModelAndView("login");
			modelAndView.addObject("message", "INVALID USERNAME OR PASSWORD");
		}

		return modelAndView;
	}
	

}
