package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @SequenceGenerator(name="employee_seq", initialValue = 10000, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq")
    @Column(name="employee_id")
    int employeeId;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date_of_joining")
    Date dateOfJoining;

    @Column(name = "company_email")
    String companyEmail;

    @Column(name = "password")
    String password;

    @Column(name = "enabled")
    boolean enabled;

    @Column(name = "role")
    String role;

    @OneToOne
    @JoinColumn(name = "user_id")
    User user;

//    @ManyToOne
//    @JoinColumn(name = "role_id")
//    Role role;

    @ManyToOne
    @JoinColumn(name = "department_id")
    Department department;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    Employee employee;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public Date getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(Date dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getUser() {
        return user;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setUser(User user) {
        this.user = user;
    }

//    public Role getRole() {
//        return role;
//    }
//
//    public void setRole(Role role) {
//        this.role = role;
//    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
