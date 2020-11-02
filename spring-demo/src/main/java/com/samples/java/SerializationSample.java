package com.samples.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.samples.java.model.Department;
import com.samples.java.model.Employee;

public class SerializationSample {

	public static void main(String[] args) {
		try {
			Employee employeel = new Employee("first 1", "lastl", "", 20, Department.BUSINESS);
			File file = new File(
					"C:\\gitworkspace\\javademo\\java-demo\\spring-demo\\src\\main\\resources\\inputs\\test.ser");
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(employeel);
			objectOutputStream.close();
			System.out.println("CVomepleted persistence");
			// Read the object
			FileInputStream fileInputStream = new FileInputStream(file);
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			Employee employeeFromFile = (Employee) objectInputStream.readObject();
			objectInputStream.close();
			employeeFromFile.auditAndUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
