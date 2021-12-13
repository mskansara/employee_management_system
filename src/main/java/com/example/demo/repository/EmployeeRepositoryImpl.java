package com.example.demo.repository;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class EmployeeRepositoryImpl implements EmployeeRepository {
    @PersistenceContext
    EntityManager em;

    // Add Methods
    @Override
    public Employee registerEmployee(Employee employee) {
        return em.merge(employee);
    }

    @Override
    public Employee addEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setDateOfJoining(employeeDto.getDateOfJoining());
        employee.setCompanyEmail(employeeDto.getCompanyEmail());
        employee.setPassword(employeeDto.getPassword());
        employee.setUser(findUserById(employeeDto.getUserId()));
//        employee.setRole(findRoleById(employeeDto.getRoleId()));
        employee.setDepartment(findDepartmentById(employeeDto.getDepartmentId()));
        employee.setEmployee(findEmployeeById(employeeDto.getManagerId()));
        return em.merge(employee);
    }

    @Override
    public Role addRole(Role role) {
        return em.merge(role);
    }

    @Override
    public Department addDepartment(Department department) {
        return em.merge(department);
    }

    @Override
    public User addUser(User user) {
        return em.merge(user);
    }

    // Find By Id Methods
    @Override
    public Employee findEmployeeById(int employeeId) {
        return em.find(Employee.class, employeeId);
    }

    @Override
    public Role findRoleById(int roleId) {
        return em.find(Role.class, roleId);
    }

    @Override
    public Department findDepartmentById(int departmentId) {
        return em.find(Department.class, departmentId);
    }

    @Override
    public User findUserById(int userId) {
        return em.find(User.class, userId);
    }

    @Override
    public List<User> fetchAllUsers() {
        String jpql = "select u from User u";
        return (List<User>)em.createQuery(jpql).getResultList();
    }

    @Override
    public Employee findEmployeeByEmail(String email) {
        String jpql = "select e from Employee e where e.companyEmail = :email";
        Query query  = em.createQuery(jpql);
        query.setParameter("email", email);
        Employee employee = (Employee)query.getSingleResult();
        return employee;
    }
}
