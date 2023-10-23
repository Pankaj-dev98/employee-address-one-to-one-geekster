package org.orgless.employeeaddress.service;

import org.orgless.employeeaddress.entity.Address;
import org.orgless.employeeaddress.entity.Employee;

import java.util.List;

public interface AddressService {
    List<Address> getAllAddresses();

    Address getAddressById(Long id);

    Address createAddress(Address address);

    Address updateAddress(Long id, Address address);

    void deleteAddress(Long id);
}
