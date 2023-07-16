package org.ravin.controllers.interfaces;

import org.ravin.models.Cliente;

public interface IClienteController extends IController<Cliente> {
    Cliente recuperarPorCpf(String cpf);
}