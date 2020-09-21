package com.example.demo.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.DepartmentService;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.JobService;
import com.example.demo.vo.Department;
import com.example.demo.vo.Employee;
import com.example.demo.vo.Job;

@RestController
@RequestMapping("/hr")
public class HrController {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private JobService jobService;
	
	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping("/employees")
	public List<Employee> employees(){
		return employeeService.getEmployees(5);
	}
	@GetMapping("/departments")
	public List<Department> departments(){
		return departmentService.getAllDepartments();
	}
	@GetMapping("/jobs")
	public List<Job> jobs(){
		return jobService.getAllJobs();
	}
	
	
}
