package org.orgless.employeeaddress.persistence;

import org.orgless.employeeaddress.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
    Employee findById(int id);
    void save(Employee employee);
    Employee updateById(Employee e);
    void deleteById(int id);
}
