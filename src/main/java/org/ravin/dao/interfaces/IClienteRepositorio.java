package org.ravin.dao.interfaces;

import org.ravin.models.Cliente;

import java.util.Optional;

public interface IClienteRepositorio extends IRepositorio<Cliente> {
    Optional<Cliente> recuperarPorCpf(String cpf);
}
