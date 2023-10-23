package org.orgless.employeeaddress.persistence;

import jakarta.persistence.EntityManager;
import org.orgless.employeeaddress.entity.Address;
import org.orgless.employeeaddress.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AddressDAOImpl implements AddressDAO {

    private EntityManager entityManager;

    @Autowired
    public AddressDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<Address> findAll() {
        var query = entityManager.createQuery("from Address", Address.class);
        return query.getResultList();
    }

    @Override
    public Address findById(Long id) {
        return entityManager.find(Address.class, id);
    }

    @Override
    public void save(Address address) {
        address.setId(0);
        entityManager.persist(address);
    }

    @Override
    public Address deleteById(Long id) {
        Address temp = entityManager.find(Address.class, id);

        if(temp == null)
            return temp;

        Employee e = temp.getEmployee();

        if(e != null)
            e.setAddress(null);

        entityManager.remove(temp);
        return temp;
    }

    @Override
    public Address updateById(Long id, Address address) {
        Address temp = entityManager.find(Address.class, id);

        if(temp == null)
            return null;

        address.setId(temp.getId());
        return entityManager.merge(address);
    }
}
