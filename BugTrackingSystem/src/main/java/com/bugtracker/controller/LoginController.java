package com.bugtracker.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.bugtracker.model.Admin;
import com.bugtracker.model.Employee;
import com.bugtracker.model.Login;
import com.bugtracker.service.UserService;

@Controller
@SessionAttributes("emp_name")
public class LoginController {

	@Autowired
	public UserService userService;

	@RequestMapping(value = "/AdminLogin", method = RequestMethod.GET)
	public ModelAndView showAdminLogin() {
		ModelAndView mav = new ModelAndView("AdminLogin");
		mav.addObject("login", new Login());
		return mav;
	}

	@RequestMapping(value = "/AdminLoginProcess", method = RequestMethod.POST)
	public ModelAndView AdminloginProcess(@ModelAttribute("login") Login login) {
		ModelAndView mav = null;
		Admin admin = userService.validateAdmin(login);
		if (null != admin) {
			mav = new ModelAndView("Admin");
		} else {
			mav = new ModelAndView("AdminLogin");
			mav.addObject("message", "Username or Password is wrong!!");
		}
		return mav;
	}

	@RequestMapping(value = "/EmployeeLogin", method = RequestMethod.GET)
	public ModelAndView showEmployeeLogin() {
		ModelAndView mav = new ModelAndView("EmployeeLogin");
		mav.addObject("login", new Login());
		return mav;
	}

	@RequestMapping(value = "/EmployeeLoginProcess", method = RequestMethod.POST)
	public ModelAndView EmployeeloginProcess(@ModelAttribute("login") Login login, HttpSession session) {
		ModelAndView mav = null;
		Employee employee = userService.validateEmployee(login);
		String designation = null;
		try {
			designation = employee.getEmployeeDesignation();
			session.setAttribute("emp_name", employee.getEmployeeName());
		} catch (NullPointerException e) {
		}

		if (null != employee && designation.equals("Coder")) {
			mav = new ModelAndView("CodingTeam");
		} else if (null != employee && designation.equals("Tester")) {
			mav = new ModelAndView("TestingTeam");
		} else if (null != employee && designation.equals("Manager")) {
			mav = new ModelAndView("Managers");
		} else {
			mav = new ModelAndView("EmployeeLogin");
			mav.addObject("message", "Username or Password is wrong!!");
		}

		return mav;
	}

}
