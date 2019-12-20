package com.demo.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.demo.java8.model.Department;
import com.demo.java8.model.Employee;
import com.demo.java8.util.ConcatenateUtil;

public class JavaEightDemo {
	public static void main(String[] args) {
		Employee employeel = new Employee("first 1", "lastl", "", 20, Department.BUSINESS);
		Employee employee2 = new Employee("first 2", "last2", "", 18, Department.TECHNOLOGY);
		Employee employee3 = new Employee("first 3", "last3", "", 27, Department.OPERATIONS);
		Employee employee4 = new Employee("first 4", "last4", "", 32, Department.SUPPORT);
		Employee employee5 = new Employee("first 5", "last5", " ", 25, Department.TECHNOLOGY);
		List<Employee> employees = Arrays.asList(employeel, employee2, employee3, employee4, employee5);

// ///////////////
		Predicate<Employee> isOld = e -> e.getAge() > 22;
		Predicate<Employee> isTechnology = e -> e.getDepartment() == Department.TECHNOLOGY;
		System.out.println("________________________");
		employees.stream().filter(isTechnology).forEach(Employee::auditAndUpdate);
		System.out.println("________________________");
		employees.stream().forEach(e -> {
			if (e.getAge() % 2 == 0)
				System.out.println(e.getAge());
		});
		System.out.println("________________________");
		employees.stream().filter(e -> e.getAge() % 2 != 0).forEach(e -> {
			System.out.println(e.getAge());
		});
		System.out.println("________________________");
		List<Employee> filteredEmployess = employees.stream()

				.filter(isTechnology).collect(Collectors.toList());
		for (Employee employee : filteredEmployess) {
			System.out.println(employee.getDepartment());
		}
		System.out.println("________________________");
		employees.stream().filter(isTechnology).filter(isOld).forEach(Employee::auditAndUpdate);
		System.out.println("________________________");
		ConcatenateUtil concatenateUtil = (s1, s2) -> {
			return (s1 + " " + s2);
		};
		System.out.println(concatenateUtil.combineNames(employeel.getFirstName(), employeel.getLastName()));
		System.out.println("________________________");

		////////////////////////////////////////////////////////////
		// Find methods in stream
		Employee emp1 = employees.stream().findFirst().get();
		System.out.println(emp1.getFirstName());

		System.out.println(employees.stream().anyMatch(isTechnology));
		System.out.println(employees.stream().allMatch(isTechnology));
		System.out.println(employees.stream().count());
		////////////////////////////////////////////////////////////
		// sort and compare
		employees.stream().sorted((e1, e2) -> e2.getAge() - e1.getAge()).forEach(Employee::auditAndUpdate);
		// Collect
		List<Employee> sortedByAgeList = employees.stream().sorted((e1, e2) -> e2.getAge() - e1.getAge())
				.collect(Collectors.toList());
		for (Employee employee : sortedByAgeList) {
			System.out.println(employee.getAge());
		}
		// collect to a custom map
		Map<String, Integer> nameAgeMap = employees.stream()
				.collect(Collectors.toMap(Employee::getFirstName, Employee::getAge));
		System.out.println(nameAgeMap);
		// grouping
		Map<Department, List<Employee>> groupListByDepartmentMap = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment));
		System.out.println(groupListByDepartmentMap);
		// partition by
		Map<Boolean, List<Employee>> partitionListByTecMap = employees.stream()
				.collect(Collectors.partitioningBy(isTechnology, Collectors.toList()));
		System.out.println(partitionListByTecMap);

	}
}
