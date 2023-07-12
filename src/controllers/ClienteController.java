package controllers;

import controllers.interfaces.IClienteController;
import dao.interfaces.IClienteRepositorio;
import models.Cliente;

import java.util.List;
import java.util.NoSuchElementException;

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

    @Override
    public Cliente recuperarPorId(int id) {
        Cliente cliente = clienteRepositorio.recuperarPorId(id);
        if (cliente != null) {
            return cliente;
        } else {
            throw new NoSuchElementException("Cliente não encontrado para o ID: " + id);
        }
    }

    @Override
    public List<Cliente> pegarLista() {
        return clienteRepositorio.pegarLista();
    }
    
    @Override
    public Cliente recuperarPorCpf(String cpf) {
        Cliente cliente = clienteRepositorio.recuperarPorCpf(cpf);
        if (cliente != null) {
            return cliente;
        } else {
            throw new NoSuchElementException("Cliente não encontrado para o CPF: " + cpf);
        }
    }
}
