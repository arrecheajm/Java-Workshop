package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.SimpleTimeZone;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	// Wire in employee service
	private EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService theEmployeeService){ // Constructor injection
		employeeService = theEmployeeService;
	}

	// add mapping for "/list"

	@GetMapping("/list")
	public String listEmployees(Model theModel) {

		List<Employee> theEmployees = employeeService.findAll();

		// add to the spring model
		theModel.addAttribute("employees", theEmployees);

		return "employees/list-employees";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel){
		// create model attribute to bind form data
		Employee theEmployee = new Employee();

		theModel.addAttribute("employee", theEmployee);

		return "employees/employee-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel){
		// get the employee from the service
		Employee theEmployee = employeeService.findById(theId);

		// set employee in the model to prepopulate the form
		theModel.addAttribute("employee", theEmployee);

		// send over to our form

		return "employees/employee-form";
	}

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee){

		// save the employee
		employeeService.save(theEmployee);

		// use a redirect to prevent duplicate submissions
		return "redirect:/employees/list";

	}

	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int theID){
		// delete the employee
		employeeService.deleteById(theID);

		// redirect to the /employees/list
		return "redirect:/employees/list";
	}
}









