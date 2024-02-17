package com.bodegami.hexagonal.config;

import com.bodegami.hexagonal.adapters.output.FindAddressByZipCodeAdapter;
import com.bodegami.hexagonal.adapters.output.UpdateCustomerAdapter;
import com.bodegami.hexagonal.application.core.usecase.UpdateCustomerUseCase;
import com.bodegami.hexagonal.application.ports.input.FindCustomerByIdInputPort;
import com.bodegami.hexagonal.application.ports.input.UpdateCustomerInputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfig {

    @Bean
    public UpdateCustomerInputPort updateCustomerUseCase(
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            FindCustomerByIdInputPort findCustomerByIdInputPort,
            UpdateCustomerAdapter updateCustomerAdapter
    ) {
        return new UpdateCustomerUseCase(findCustomerByIdInputPort, findAddressByZipCodeAdapter, updateCustomerAdapter);
    }
}
