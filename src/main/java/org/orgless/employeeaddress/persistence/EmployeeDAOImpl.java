package org.orgless.employeeaddress.persistence;

import jakarta.persistence.EntityManager;
import org.orgless.employeeaddress.entity.Address;
import org.orgless.employeeaddress.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private final EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        var query = entityManager.createQuery("from Employee", Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee findById(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public void save(Employee employee) {
        entityManager.persist(employee);
    }

    @Override
    public Employee updateById(Employee e) {
        Employee temp = entityManager.find(Employee.class, e.getId());

        if(temp == null)
            return null;

        Address tempAddress = e.getAddress();

        if(tempAddress != null)
            tempAddress.setId(temp.getAddress().getId());

        return entityManager.merge(e);
    }

    @Override
    public void deleteById(int id) {
        Employee e = entityManager.find(Employee.class, id);

        if(e != null)
            entityManager.remove(e);
    }
}
