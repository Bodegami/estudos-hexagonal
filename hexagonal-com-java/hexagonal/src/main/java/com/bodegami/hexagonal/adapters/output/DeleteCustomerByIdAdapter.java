package com.bodegami.hexagonal.adapters.output;

import com.bodegami.hexagonal.adapters.output.repository.CustomerRepository;
import com.bodegami.hexagonal.application.ports.output.DeleteCustomerByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteCustomerByIdAdapter implements DeleteCustomerByIdOutputPort {

    @Autowired
    private CustomerRepository customerRepository;

    public void delete(String id) {
        customerRepository.deleteById(id);
    }

}
