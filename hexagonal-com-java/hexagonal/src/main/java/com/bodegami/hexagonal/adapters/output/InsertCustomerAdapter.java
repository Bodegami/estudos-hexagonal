package com.bodegami.hexagonal.adapters.output;

import com.bodegami.hexagonal.adapters.output.repository.CustomerRepository;
import com.bodegami.hexagonal.adapters.output.repository.entity.CustomerEntity;
import com.bodegami.hexagonal.adapters.output.repository.mapper.CustomerEntityMapper;
import com.bodegami.hexagonal.application.core.domain.Customer;
import com.bodegami.hexagonal.application.ports.output.InsertCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsertCustomerAdapter implements InsertCustomerOutputPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;
    @Override
    public void insert(Customer customer) {
        CustomerEntity customerEntity = customerEntityMapper.toCustomerEntity(customer);
        customerRepository.save(customerEntity);
    }
}
