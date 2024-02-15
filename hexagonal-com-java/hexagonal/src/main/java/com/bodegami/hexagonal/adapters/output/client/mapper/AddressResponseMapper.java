package com.bodegami.hexagonal.adapters.output.client.mapper;


import com.bodegami.hexagonal.adapters.output.client.response.AddressResponse;
import com.bodegami.hexagonal.application.core.domain.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {

    Address toAddress(AddressResponse addressResponse);
}
