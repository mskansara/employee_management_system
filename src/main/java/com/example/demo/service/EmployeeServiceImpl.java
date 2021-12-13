package com.example.demo.service;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository empRepo;

    @Override
    public Employee registerEmployee(Employee employee) {
        return empRepo.registerEmployee(employee);
    }

    @Override
    public Employee addEmployee(EmployeeDto employeeDto) {
        return empRepo.addEmployee(employeeDto);
    }

    @Override
    public Role addRole(Role role) {
        return empRepo.addRole(role);
    }

    @Override
    public Department addDepartment(Department department) {
        return empRepo.addDepartment(department);
    }

    @Override
    public User addUser(User user) {
        return empRepo.addUser(user);
    }

    @Override
    public List<User> fetchAllUsers() {
        return empRepo.fetchAllUsers();
    }

}
