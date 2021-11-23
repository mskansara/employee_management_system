package com.example.demo.repository;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;

import java.util.List;

public interface EmployeeRepository {
    public Employee registerEmployee(Employee employee);
    public Employee addEmployee(EmployeeDto employeeDto);
    public Role addRole(Role role);
    public Department addDepartment(Department department);
    public User addUser(User user);

    public Employee findEmployeeById(int employeeId);
    public Role findRoleById(int roleId);
    public Department findDepartmentById(int departmentId);
    public User findUserById(int userId);
    public List<User> fetchAllUsers();
}
