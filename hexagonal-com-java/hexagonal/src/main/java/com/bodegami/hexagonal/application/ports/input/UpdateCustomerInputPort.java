package com.bodegami.hexagonal.application.ports.input;

import com.bodegami.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerInputPort {

    void update(Customer customer, String zipCode);

}
