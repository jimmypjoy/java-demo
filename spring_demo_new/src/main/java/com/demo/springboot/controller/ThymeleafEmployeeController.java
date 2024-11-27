package com.demo.springboot.controller;

import com.demo.springboot.entity.Employee;
import com.demo.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class ThymeleafEmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Display all employees with add form default values
    @GetMapping
    public String viewEmployees(Model model) {
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);

        // Set default values for the new employee form
        Employee defaultEmployee = new Employee();
        defaultEmployee.setName("Test Name1");
        defaultEmployee.setDepartmentId(2);
        defaultEmployee.setAddress("Test Street 1");
        defaultEmployee.setSalary(10000.0);
        defaultEmployee.setSkill("Python");
        defaultEmployee.setComments("test comment1");
        defaultEmployee.setAge(30);
        model.addAttribute("employee", defaultEmployee);

        return "employee";
    }

    // Add a new employee
    @PostMapping("/add")
    public String addEmployee(@ModelAttribute Employee employee, RedirectAttributes redirectAttributes) {
        employeeService.createEmployee(employee);
        redirectAttributes.addFlashAttribute("message", "Employee added successfully!");
        return "redirect:/employees";
    }

    // Update an existing employee
    @PostMapping("/update/{id}")
    public String updateEmployee(@PathVariable Integer id, @ModelAttribute Employee employeeDetails, RedirectAttributes redirectAttributes) {
        employeeService.updateEmployee(id, employeeDetails);
        redirectAttributes.addFlashAttribute("message", "Employee updated successfully!");
        return "redirect:/employees";
    }

    // Delete an employee
    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        employeeService.deleteEmployee(id);
        redirectAttributes.addFlashAttribute("message", "Employee deleted successfully!");
        return "redirect:/employees";
    }
}
