package org.orgless.employeeaddress.service;

import jakarta.transaction.Transactional;
import org.orgless.employeeaddress.entity.Employee;
import org.orgless.employeeaddress.persistence.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee getEmployeeById(int id) {
        return employeeDAO.findById(id);
    }

    @Override
    @Transactional
    public void addEmployee(Employee employee) {
        employeeDAO.save(employee);
    }

    @Override
    @Transactional
    public Employee updateEmployeeById(Employee employee, int id) {
        employee.setId(id);
        return employeeDAO.updateById(employee);
    }

    @Override
    @Transactional
    public void deleteEmployeeById(int id) {
        employeeDAO.deleteById(id);
    }
}
