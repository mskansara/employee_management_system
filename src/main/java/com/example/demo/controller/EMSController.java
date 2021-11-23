package com.example.demo.controller;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class EMSController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping(value = "register")
    public Employee registerEmployee(@RequestBody Employee employee) {
        return employeeService.registerEmployee(employee);
    }

    @GetMapping(value = "/")
    public String hello() {
        return "Hello";
    }

    @PostMapping(value = "/addEmployee")
    public Employee addEmployee(@RequestBody EmployeeDto employeeDto) {
        return employeeService.addEmployee(employeeDto);
    }

    @PostMapping(value = "/addRole")
    public Role addRoles(@RequestBody Role role) {
        return employeeService.addRole(role);
    }

    @PostMapping(value = "/addDepartment")
    public Department addDepartment(@RequestBody Department department) {
        return employeeService.addDepartment(department);
    }

    @PostMapping(value = "/addUser")
    public User addUser(@RequestBody User user) {
        return employeeService.addUser(user);
    }

    @GetMapping(value = "/fetchAllUsers")
    public List<User> fetchAllUsers() {
        return employeeService.fetchAllUsers();
    }
}

