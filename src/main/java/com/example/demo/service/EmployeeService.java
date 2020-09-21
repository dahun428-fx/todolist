package com.example.demo.service;

import java.util.List;

import com.example.demo.vo.Employee;

public interface EmployeeService {

	List<Employee> getEmployees(int limit);
	List<Employee> getManagers();
	Employee getEmployee(int id);
	void insertEmployee(Employee employee);
	void deleteEmployee(int id);
	void updateEmployee(Employee employee);
}
