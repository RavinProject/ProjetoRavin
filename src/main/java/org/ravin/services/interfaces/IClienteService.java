package org.ravin.services.interfaces;

import org.ravin.models.Cliente;

import java.util.Optional;

public interface IClienteService extends IService <Cliente>{
    Optional<Cliente> recuperarPorCpf(String cpf);
}
