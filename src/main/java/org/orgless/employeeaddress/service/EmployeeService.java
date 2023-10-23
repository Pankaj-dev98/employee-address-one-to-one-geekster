package org.orgless.employeeaddress.service;

import org.orgless.employeeaddress.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();
    Employee getEmployeeById(int id);
    void addEmployee(Employee employee);
    Employee updateEmployeeById(Employee employee, int id);
    void deleteEmployeeById(int id);
}
