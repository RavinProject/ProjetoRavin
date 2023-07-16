package org.backend.services.interfaces;

import models.Cliente;

import java.util.Optional;

public interface IClienteService extends IService <Cliente>{
    Optional<Cliente> recuperarPorCpf(String cpf);
}
