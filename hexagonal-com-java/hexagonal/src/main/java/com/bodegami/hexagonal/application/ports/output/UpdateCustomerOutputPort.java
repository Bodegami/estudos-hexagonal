package com.bodegami.hexagonal.application.ports.output;

import com.bodegami.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerOutputPort {

    void update(Customer customer);

}
