package com.bodegami.hexagonal.adapters.input.controller;

import com.bodegami.hexagonal.adapters.input.controller.mapper.CustomerMapper;
import com.bodegami.hexagonal.adapters.input.controller.request.CustomerRequest;
import com.bodegami.hexagonal.adapters.input.controller.response.CustomerResponse;
import com.bodegami.hexagonal.application.core.domain.Customer;
import com.bodegami.hexagonal.application.ports.input.FindCustomerByIdInputPort;
import com.bodegami.hexagonal.application.ports.input.InsertCustomerInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private InsertCustomerInputPort insertCustomerInputPort;

    @Autowired
    private FindCustomerByIdInputPort findCustomerByIdInputPort;

    @Autowired
    private CustomerMapper customerMapper;

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody @Valid CustomerRequest customerRequest) {
        Customer customer = customerMapper.toCustomer(customerRequest);
        insertCustomerInputPort.insert(customer, customerRequest.getZipCode());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable("id") final String id) {
        Customer customer = findCustomerByIdInputPort.find(id);
        return ResponseEntity.ok(customerMapper.toCustomerResponse(customer));
    }

}
