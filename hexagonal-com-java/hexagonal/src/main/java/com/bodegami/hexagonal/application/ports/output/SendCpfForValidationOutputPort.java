package com.bodegami.hexagonal.application.ports.output;

public interface SendCpfForValidationOutputPort {

    void send(String cpf);

}
