package org.ravin.dao.interfaces;

import org.ravin.models.Cliente;
import org.ravin.utils.interfaces.IGeradorId;

import java.util.Optional;

public interface IClienteRepositorio extends IRepositorio<Cliente>, IGeradorId<Cliente> {
    Optional<Cliente> recuperarClientePorCpf(String cpf);

    default int getId(Cliente cliente){
        return cliente.getId();
    }
}
