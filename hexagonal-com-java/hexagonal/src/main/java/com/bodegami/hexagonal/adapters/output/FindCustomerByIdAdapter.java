package com.bodegami.hexagonal.adapters.output;

import com.bodegami.hexagonal.adapters.output.repository.CustomerRepository;
import com.bodegami.hexagonal.adapters.output.repository.mapper.CustomerEntityMapper;
import com.bodegami.hexagonal.application.core.domain.Customer;
import com.bodegami.hexagonal.application.ports.output.FindCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindCustomerByIdAdapter implements FindCustomerOutputPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public Optional<Customer> find(String id) {
        return customerRepository.findById(id)
                .map(customerEntityMapper::toCustomer);
    }
}
