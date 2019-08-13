package com.bugtracker.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bugtracker.model.Employee;
import com.bugtracker.service.AddService;

@Controller
public class AddController {
	AddService addService= new AddService();
	@RequestMapping(value="/addEmployee")
	public String addEmployee(Model model) {
		Employee employee= new Employee();
		model.addAttribute("employee", employee);
		return "addEmployee";
		
	}
	
	@RequestMapping(value = "/addProcess", method = RequestMethod.POST)
	public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse httpServletResponse,
			@ModelAttribute("employee") Employee employee) {
		ModelAndView modelAndView;
		System.out.println(employee.getEmployeeEmail() + " " + employee.getEmployeePassword());
		
		if (AddService.addEmployees(employee)) {
			modelAndView = new ModelAndView("admin");
			modelAndView.addObject("message", "SUCCESS");
		} else {
			modelAndView = new ModelAndView("admin");
			modelAndView.addObject("message", "FAILURE");
		}

		return modelAndView;
	}
	
	@RequestMapping(value = "/removeEmployee", method = RequestMethod.POST)
	public ModelAndView removeEmployee(HttpServletRequest request, HttpServletResponse httpServletResponse,
			@ModelAttribute("employee") Employee employee) {
		ModelAndView modelAndView;
		System.out.println(employee.getEmployeeEmail());
		
		if (AddService.removeEmployee(employee)) {
			modelAndView = new ModelAndView("admin");
			modelAndView.addObject("message", "SUCCESS");
		} else {
			modelAndView = new ModelAndView("admin");
			modelAndView.addObject("message", "FAILURE");
		}

		return modelAndView;
	}
	
	
	
	@RequestMapping(value="/updateProfile")
	public String update(Model model,@ModelAttribute("employee") Employee employee) {
//		Employee employee= new Employee();
//		model.addAttribute("employee", employee);
		return "updateEmployeeProfile";
		
	}
	
	
	
	@RequestMapping(value = "/updateProcess", method = {/*RequestMethod.GET,*/RequestMethod.POST})
	public ModelAndView updateEmployee(HttpServletRequest request, HttpServletResponse httpServletResponse,
			@ModelAttribute("employee") Employee employee) {
		ModelAndView modelAndView;
		if (AddService.updateEmployee(employee)) {
			modelAndView = new ModelAndView("updateEmployeeProfile");
			modelAndView.addObject("message", "SUCCESS");
		} else {
			modelAndView = new ModelAndView("updateEmployeeProfile");
			modelAndView.addObject("message", "FAILURE");
		}
		return modelAndView;
	}
	
	
}
