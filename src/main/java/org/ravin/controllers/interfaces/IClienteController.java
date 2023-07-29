package org.ravin.controllers.interfaces;

import org.ravin.models.Cliente;
import org.ravin.utils.exceptions.EntidadeNaoEncontradaException;

import java.util.List;

public interface IClienteController extends IController<Cliente> {
    Cliente recuperarPorCpf(String cpf) throws EntidadeNaoEncontradaException;

    @Override
    default Cliente recuperarPorId(int id) throws EntidadeNaoEncontradaException {
        return null;
    }

    @Override
    default List<Cliente> recuperarTodos() {
        return null;
    }
}