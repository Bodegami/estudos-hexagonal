package com.bodegami.hexagonal.adapters.output.repository.mapper;

import com.bodegami.hexagonal.adapters.output.repository.entity.CustomerEntity;
import com.bodegami.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {

    CustomerEntity toCustomerEntity(Customer customer);

}
