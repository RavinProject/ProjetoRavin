package controllers;

import controllers.interfaces.IClienteController;
import dao.ClienteRepositorio;
import dao.interfaces.IClienteRepositorio;
import models.Cliente;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class ClienteController implements IClienteController {
    private final IClienteRepositorio clienteRepositorio;
    public ClienteController(IClienteRepositorio clienteRepository) {
        this.clienteRepositorio = clienteRepository;
    }

    @Override
    public void atualizar(Cliente objeto) {
        clienteRepositorio.atualizar(objeto);
    }

    @Override
    public boolean remover(Cliente objeto) {
        clienteRepositorio.remover(objeto);
        return true;
    }

    @Override
    public void inserir(Cliente objeto) {
        clienteRepositorio.inserir(objeto);
    }

    // TODO testar
    @Override
    public Cliente recuperarPorId(int id) {
        Optional<Cliente> cliente = clienteRepositorio.recuperarPorId(id);
        if (cliente.isPresent()) {
            return cliente.get();
        } else {
            throw new NoSuchElementException("Cliente não encontrado para o ID: " + id);
        }
    }

    // TODO testar
    @Override
    public List<Cliente> pegarLista() {
        return clienteRepositorio.pegarLista();
    }
    @Override
    public Cliente recuperarPorCpf(String cpf) {
        Optional<Cliente> cliente = clienteRepositorio.recuperarPorCpf(cpf);
        if (cliente.isPresent()) {
            return cliente.get();
        } else {
            throw new NoSuchElementException("Cliente não encontrado para o CPF: " + cpf);
        }
    }
}
