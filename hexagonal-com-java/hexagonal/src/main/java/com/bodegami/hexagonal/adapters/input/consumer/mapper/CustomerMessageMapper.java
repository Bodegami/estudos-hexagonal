package com.bodegami.hexagonal.adapters.input.consumer.mapper;

import com.bodegami.hexagonal.adapters.input.consumer.message.CustomerMessage;
import com.bodegami.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMessageMapper {

    @Mapping(target = "address", ignore = true)
    Customer toCustomer(CustomerMessage customerMessage);

}
