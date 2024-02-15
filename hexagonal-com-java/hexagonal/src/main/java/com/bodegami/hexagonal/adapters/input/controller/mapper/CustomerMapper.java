package com.bodegami.hexagonal.adapters.input.controller.mapper;

import com.bodegami.hexagonal.adapters.input.controller.request.CustomerRequest;
import com.bodegami.hexagonal.adapters.input.controller.response.CustomerResponse;
import com.bodegami.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "isValidCpf", ignore = true)
    Customer toCustomer(CustomerRequest customerRequest);

    CustomerResponse toCustomerResponse(Customer customer);

}
