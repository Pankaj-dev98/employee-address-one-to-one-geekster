package org.orgless.employeeaddress.service;

import jakarta.transaction.Transactional;
import org.orgless.employeeaddress.entity.Address;
import org.orgless.employeeaddress.persistence.AddressDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService{
    private AddressDAO addressDAO;

    @Autowired
    public AddressServiceImpl(AddressDAO addressDAO) {
        this.addressDAO = addressDAO;
    }

    @Override
    public List<Address> getAllAddresses() {
        return addressDAO.findAll();
    }

    @Override
    public Address getAddressById(Long id) {
        return addressDAO.findById(id);
    }

    @Override
    @Transactional
    public Address createAddress(Address address) {
        addressDAO.save(address);
        return address;
    }

    @Override
    @Transactional
    public Address updateAddress(Long id, Address address) {
        return addressDAO.updateById(id, address);
    }

    @Override
    @Transactional
    public void deleteAddress(Long id) {
        addressDAO.deleteById(id);
    }
}
