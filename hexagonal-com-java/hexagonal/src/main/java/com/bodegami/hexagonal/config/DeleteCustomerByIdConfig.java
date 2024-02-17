package com.bodegami.hexagonal.config;

import com.bodegami.hexagonal.adapters.output.DeleteCustomerByIdAdapter;
import com.bodegami.hexagonal.application.core.usecase.DeleteCustomerByIdUseCase;
import com.bodegami.hexagonal.application.ports.input.DeleteCustomerByIdInputPort;
import com.bodegami.hexagonal.application.ports.input.FindCustomerByIdInputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCustomerByIdConfig {

    @Bean
    public DeleteCustomerByIdInputPort deleteCustomerByIdUseCase(
            FindCustomerByIdInputPort findCustomerByIdInputPort,
            DeleteCustomerByIdAdapter deleteCustomerByIdAdapter
    ) {
        return new DeleteCustomerByIdUseCase(findCustomerByIdInputPort, deleteCustomerByIdAdapter);
    }
}
