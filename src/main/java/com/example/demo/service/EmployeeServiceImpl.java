package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.vo.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDao employeeDao;
	
	public Employee getEmployee(int id) {
		return employeeDao.getEmployee(id);
	} 
	public List<Employee> getEmployees(int limit) {
		return employeeDao.getEmployees(limit);
	}
	public List<Employee> getManagers() {
		return employeeDao.getManagers();
	}
	public void insertEmployee(Employee employee) {
		employeeDao.insertEmployee(employee);
	}
	public void updateEmployee(Employee employee) {
		employeeDao.updateEmployee(employee);
	}
	public void deleteEmployee(int id) {
		employeeDao.deleteEmployee(id);
	}
}
