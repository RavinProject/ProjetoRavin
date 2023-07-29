package org.ravin.controllers;

import org.ravin.controllers.interfaces.IClienteController;
import org.ravin.models.Cliente;
import org.ravin.services.interfaces.IClienteService;
import org.ravin.utils.exceptions.EntidadeNaoEncontradaException;

import java.util.List;
import java.util.Optional;

public class ClienteController implements IClienteController {

    // Injeção de dependência
    private final IClienteService clienteService;
    public ClienteController(IClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @Override
    public void inserir(Cliente objeto) {
        clienteService.inserir(objeto);
    }

    @Override
    public Cliente recuperarPorId(int id) throws EntidadeNaoEncontradaException {
        Optional<Cliente> cliente = clienteService.recuperarPorId(id);
        if (cliente.isPresent()) {
            return cliente.get();
        } else {
            throw new EntidadeNaoEncontradaException("Cliente não encontrado para o ID: " + id);
        }
    }

    @Override
    public Cliente recuperarPorCpf(String cpf) throws EntidadeNaoEncontradaException {
        Optional<Cliente> cliente = clienteService.recuperarPorCpf(cpf);
        if (cliente.isPresent()) {
            return cliente.get();
        } else {
            throw new EntidadeNaoEncontradaException("Cliente não encontrado para o CPF: " + cpf);
        }
    }

    @Override
    public List<Cliente> recuperarTodos() {
        return clienteService.recuperarTodos();
    }

    @Override
    public void atualizar(Cliente objeto) {
        clienteService.atualizar(objeto);
    }

    @Override
    public boolean remover(Cliente objeto) {
        clienteService.remover(objeto);
        return true;
    }
}
