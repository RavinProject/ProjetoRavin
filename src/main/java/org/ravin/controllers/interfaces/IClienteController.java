package org.ravin.controllers.interfaces;

import org.ravin.models.Cliente;
import org.ravin.utils.exceptions.EntidadeNaoEncontradaException;

public interface IClienteController extends IController<Cliente> {
    Cliente recuperarPorCpf(String cpf) throws EntidadeNaoEncontradaException;
}