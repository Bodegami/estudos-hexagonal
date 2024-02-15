package com.bodegami.hexagonal.application.core.usecase;

import com.bodegami.hexagonal.application.core.domain.Customer;
import com.bodegami.hexagonal.application.ports.input.FindCustomerByIdInputPort;
import com.bodegami.hexagonal.application.ports.output.FindCustomerOutputPort;

public class FindCustomerByIdUseCase implements FindCustomerByIdInputPort {

    private final FindCustomerOutputPort findCustomerOutputPort;

    public FindCustomerByIdUseCase(FindCustomerOutputPort findCustomerOutputPort) {
        this.findCustomerOutputPort = findCustomerOutputPort;
    }

    @Override
    public Customer find(String id) {
        return findCustomerOutputPort.find(id)
                .orElseThrow(() -> new RuntimeException("Customer not found!"));
    }

}
