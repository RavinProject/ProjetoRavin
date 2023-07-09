package controllers;

import controllers.interfaces.IClienteController;
import models.Cliente;
import models.Pessoa;

import java.util.List;

public class ClienteController implements IClienteController {

    public ClienteController() {
        
    }

    @Override
    public void atualizar(Cliente objeto) {

    }

    @Override
    public boolean remover(Cliente objeto) {
        return false;
    }

    @Override
    public void inserir(Cliente objeto) {

    }

    @Override
    public Cliente recuperarPorId(int id) {
        return null;
    }

    @Override
    public List<Cliente> pegarLista() {
        return null;
    }

    public Cliente buscaPorCpf(String cpf) {
        for (Pessoa pessoa : pegarLista()) {
            if (pessoa.getCpf().equals(cpf) && pessoa instanceof Cliente) {
                return (Cliente) pessoa;
            }
        }
        return null;
    }
}
