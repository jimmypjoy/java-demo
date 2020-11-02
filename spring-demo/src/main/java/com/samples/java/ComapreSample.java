package com.samples.java;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.samples.java.model.Department;
import com.samples.java.model.Employee;

class EmployeeAgeComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee employeel, Employee employee2) {
		return employeel.getAge() - employee2.getAge();
	}

}

public class ComapreSample {

	public static void main(String[] args) {
		Employee employeel = new Employee("first 1", "lastl", "", 20, Department.BUSINESS);
		Employee employee2 = new Employee("first 2", "last2", "", 18, Department.TECHNOLOGY);
		Employee employee3 = new Employee("first 3", "last3", "", 27, Department.OPERATIONS);
		Employee employee4 = new Employee("first 4", "last4", "", 32, Department.SUPPORT);
		Employee employee5 = new Employee("first 5", "last5", " ", 25, Department.TECHNOLOGY);
		List<Employee> employees = Arrays.asList(employeel, employee2, employee3, employee4, employee5);
		employees.stream().forEach(e -> e.auditAndUpdate());
		System.out.println("After sorting");
		Collections.sort(employees, new EmployeeAgeComparator());
		employees.stream().forEach(e -> e.auditAndUpdate());
		System.out.println("After sorting using Lamda: age desc");
		Collections.sort(employees, (e1, e2) -> e2.getAge() - e1.getAge());
		employees.stream().forEach(e -> e.auditAndUpdate());

	}

}
