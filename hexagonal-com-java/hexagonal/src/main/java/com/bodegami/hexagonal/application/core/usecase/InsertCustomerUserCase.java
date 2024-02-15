package com.bodegami.hexagonal.application.core.usecase;

import com.bodegami.hexagonal.application.core.domain.Customer;
import com.bodegami.hexagonal.application.ports.output.FindAddressByZipCodeOutputPort;
import com.bodegami.hexagonal.application.ports.output.InsertCustomerOutputPort;

public class InsertCustomerUserCase {

    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;
    private final InsertCustomerOutputPort insertCustomerOutputPort;

    public InsertCustomerUserCase(FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort, InsertCustomerOutputPort insertCustomerOutputPort) {
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.insertCustomerOutputPort = insertCustomerOutputPort;
    }

    public void insert(Customer customer, String zipCode) {
        var address = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        insertCustomerOutputPort.insert(customer);
    }

}
