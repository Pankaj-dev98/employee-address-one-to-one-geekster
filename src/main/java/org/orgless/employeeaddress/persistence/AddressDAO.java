package org.orgless.employeeaddress.persistence;

import org.orgless.employeeaddress.entity.Address;

import java.util.List;

public interface AddressDAO {
    List<Address> findAll();

    Address findById(Long id);

    void save(Address address);

    Address deleteById(Long id);

    Address updateById(Long id, Address address);
}
