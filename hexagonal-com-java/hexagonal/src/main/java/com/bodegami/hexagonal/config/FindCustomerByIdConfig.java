package com.bodegami.hexagonal.config;

import com.bodegami.hexagonal.adapters.output.FindCustomerByIdAdapter;
import com.bodegami.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import com.bodegami.hexagonal.application.ports.input.FindCustomerByIdInputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindCustomerByIdConfig {

    @Bean
    public FindCustomerByIdInputPort findCustomerByIdUseCase(
            FindCustomerByIdAdapter findCustomerByIdAdapter
    ) {
        return new FindCustomerByIdUseCase(findCustomerByIdAdapter);
    }
}
