package com.bodegami.hexagonal.application.core.usecase;

import com.bodegami.hexagonal.application.core.domain.Address;
import com.bodegami.hexagonal.application.core.domain.Customer;
import com.bodegami.hexagonal.application.ports.input.FindCustomerByIdInputPort;
import com.bodegami.hexagonal.application.ports.output.FindAddressByZipCodeOutputPort;
import com.bodegami.hexagonal.application.ports.output.UpdateCustomerOutputPort;

public class UpdateCustomerUseCase {

    private final FindCustomerByIdInputPort findCustomerByIdInputPort;
    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;
    private final UpdateCustomerOutputPort updateCustomerOutputPort;

    public UpdateCustomerUseCase(
            FindCustomerByIdInputPort findCustomerByIdInputPort,
            FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
            UpdateCustomerOutputPort updateCustomerOutputPort
    ) {
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.updateCustomerOutputPort = updateCustomerOutputPort;
    }

    public void update(Customer customer, String zipCode) {
        findCustomerByIdInputPort.find(customer.getId());
        Address address = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        updateCustomerOutputPort.update(customer);
    }

}
