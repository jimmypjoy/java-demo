package com.samples.java.model;

import java.io.Serializable;

public class Employee implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -635482957578937357L;
	private String firstName;
	private String lastName;
	private String fullName;
	private int age;
	private Department department;

	public Employee(String firstName, String lastName, String fullName, int age, Department department) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.fullName = fullName;
		this.age = age;
		this.department = department;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public void auditAndUpdate() {
		this.setFullName(this.getFirstName() + " " + this.getLastName());
		System.out.println(
				this.getFullName() + ": Age: " + this.getAge() + " :Department: " + this.getDepartment().toString());
	}

}
