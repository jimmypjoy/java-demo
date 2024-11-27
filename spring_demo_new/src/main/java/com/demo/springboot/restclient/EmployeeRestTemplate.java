package com.demo.springboot.restclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.demo.springboot.entity.Employee;

@Component
public class EmployeeRestTemplate {

	@Value("${employeeservice.url}")
	private String employeeServiceURL;

	@Value("${profile.demo.property}")
	private String demoProfileProperty;

	@Autowired
	private RestTemplate restTemplate;

	public void fetchEmployee() {
		Employee employee = restTemplate.getForObject(employeeServiceURL + "employees/1", Employee.class);
		System.out.println("#".repeat(50));
		System.out.println("demoProfileProperty from property file: " + demoProfileProperty);
		System.out.println("employeeServiceURL from property file: " + employeeServiceURL);
		System.out.println(employee.toString());
		System.out.println("#".repeat(50));
	}

}
