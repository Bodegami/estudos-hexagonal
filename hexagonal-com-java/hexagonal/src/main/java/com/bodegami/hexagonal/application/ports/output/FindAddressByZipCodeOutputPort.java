package com.bodegami.hexagonal.application.ports.output;

import com.bodegami.hexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {

    Address find(String zipCode);

}
