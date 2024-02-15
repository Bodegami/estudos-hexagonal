package com.bodegami.hexagonal.application.core.usecase;

import com.bodegami.hexagonal.application.core.domain.Customer;
import com.bodegami.hexagonal.application.ports.output.FindCustomerOutputPort;

public class FindCustomerByIdUseCase {

    private final FindCustomerOutputPort findCustomerOutputPort;

    public FindCustomerByIdUseCase(FindCustomerOutputPort findCustomerOutputPort) {
        this.findCustomerOutputPort = findCustomerOutputPort;
    }

    public Customer find(String id) {
        return findCustomerOutputPort.find(id)
                .orElseThrow(() -> new RuntimeException("Customer not found!"));
    }

}
