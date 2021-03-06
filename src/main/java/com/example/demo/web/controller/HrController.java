package com.example.demo.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
	@GetMapping("/managers")
	public List<Employee> managers(){
		return employeeService.getManagers();
	}
	@GetMapping("employee/{id}")
	public Employee employee(@PathVariable("id") int id) {
		return employeeService.getEmployee(id);
	}
	@PostMapping("/employees")
	public List<Employee> insertEmployee(@RequestBody Employee employee){
		employeeService.insertEmployee(employee);
		return employeeService.getEmployees(5);
	}
	@DeleteMapping("/employees/{id}")
	public List<Employee> deleteEmployee(@PathVariable("id") int id){
		employeeService.deleteEmployee(id);
		return employeeService.getEmployees(5);
	}
	@PutMapping("/employees/{id}")
	public List<Employee> updateEmployee(@RequestBody Employee employee){
		employeeService.updateEmployee(employee);
		return employeeService.getEmployees(5);
	}
	
	
	
}
