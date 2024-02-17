package com.bodegami.hexagonal.config;

import com.bodegami.hexagonal.adapters.output.FindAddressByZipCodeAdapter;
import com.bodegami.hexagonal.adapters.output.InsertCustomerAdapter;
import com.bodegami.hexagonal.adapters.output.SendCpfValidationAdapter;
import com.bodegami.hexagonal.application.core.usecase.InsertCustomerUseCase;
import com.bodegami.hexagonal.application.ports.input.InsertCustomerInputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {

    @Bean
    public InsertCustomerInputPort insertCustomerUseCase(
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            InsertCustomerAdapter insertCustomerAdapter,
            SendCpfValidationAdapter sendCpfValidationAdapter
    ) {
        return new InsertCustomerUseCase(findAddressByZipCodeAdapter, insertCustomerAdapter, sendCpfValidationAdapter);
    }
}
