package com.demo.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.springboot.entity.Employee;
import com.demo.springboot.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	// Get an employee by ID
	public Employee getEmployeeById(Integer id) {
		return employeeRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Employee not found with ID: " + id));
	}

	// Create a new employee
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	// Update an existing employee
	public Employee updateEmployee(Integer id, Employee employeeDetails) {
		Employee employee = getEmployeeById(id); // Fetch the existing employee
		employee.setName(employeeDetails.getName());
		employee.setDepartmentId(employeeDetails.getDepartmentId());
		employee.setAddress(employeeDetails.getAddress());
		employee.setSalary(employeeDetails.getSalary());
		employee.setSkill(employeeDetails.getSkill());
		employee.setComments(employeeDetails.getComments());
		employee.setAge(employeeDetails.getAge());
		return employeeRepository.save(employee); // Save updated employee
	}

	// Delete an employee by ID
	public void deleteEmployee(Integer id) {
		if (!employeeRepository.existsById(id)) {
			throw new RuntimeException("Employee not found with ID: " + id);
		}
		employeeRepository.deleteById(id);
	}
}
