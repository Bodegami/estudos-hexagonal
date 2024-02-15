package com.bodegami.hexagonal.application.ports.output;

import com.bodegami.hexagonal.application.core.domain.Customer;

import java.util.Optional;

public interface FindCustomerOutputPort {

    Optional<Customer> find(String id);

}
