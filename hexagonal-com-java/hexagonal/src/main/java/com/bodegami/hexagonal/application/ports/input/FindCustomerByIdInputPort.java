package com.bodegami.hexagonal.application.ports.input;

import com.bodegami.hexagonal.application.core.domain.Customer;

public interface FindCustomerByIdInputPort {

    Customer find(String id);

}
