package com.bugtracker.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;


import com.bugtracker.model.Login;
import com.bugtracker.service.UserServiceImpl;


@Controller
@SessionAttributes("username")
public class LoginController {

	UserServiceImpl userServiceImpl = new UserServiceImpl();

	@RequestMapping(value = "/login")
	public String login(Model model,HttpSession session) {
		return "login";
	}
	
	@RequestMapping(value = "/emplogin")
	public String emplogin(Model model) {
		return "employeelogin";
	}

	@RequestMapping(value = "/adminlog", method = RequestMethod.POST)
	public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse httpServletResponse,
			@ModelAttribute("login") Login login,HttpSession session) {
		ModelAndView modelAndView;
//		String admin= (String) session.getAttribute("admin");
//		String button=(String) session.getAttribute("button");
//		if(null==admin) {
//			System.out.println("SESSION ENDED");
//			modelAndView = new ModelAndView("login");
//		}
		 if (userServiceImpl.loginValidation(login)) {
			session.setAttribute("admin",login.getUsername());
			modelAndView = new ModelAndView("admin");
		} else {
			modelAndView = new ModelAndView("login");
			modelAndView.addObject("message", "INVALID USERNAME OR PASSWORD");
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request,HttpSession session) {
        session = request.getSession();
        session.removeAttribute("admin");
        session.invalidate();
        return "login";
    }
	
	
	
	@RequestMapping(value = "/employeelog", method = RequestMethod.POST)
	public ModelAndView emploginProcess(HttpServletRequest request, HttpServletResponse httpServletResponse,
			@ModelAttribute("login") Login login) {
		ModelAndView modelAndView = new ModelAndView();
		if (userServiceImpl.emploginValidation(login)) {
		        modelAndView.addObject("username", login.getUsername());
		        modelAndView.setViewName("employee");
		} else {
			modelAndView = new ModelAndView("employeelogin");
			modelAndView.addObject("message", "INVALID USERNAME OR PASSWORD");
		}

		return modelAndView;
	}
	

}
