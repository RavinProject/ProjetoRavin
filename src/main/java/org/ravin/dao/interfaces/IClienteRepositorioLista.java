package org.ravin.dao.interfaces;

import org.ravin.models.Cliente;
import org.ravin.utils.interfaces.IGeradorId;

import java.util.Optional;

public interface IClienteRepositorioLista extends IRepositorioLista<Cliente>, IGeradorId<Cliente> {
    Optional<Cliente> recuperarPorCpf(String cpf);

    default int getId(Cliente cliente){
        return cliente.getId();
    }
}