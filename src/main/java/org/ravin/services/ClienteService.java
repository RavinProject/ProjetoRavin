package org.ravin.services;

import org.ravin.dao.ListasDados;
import org.ravin.dao.interfaces.IClienteRepositorioLista;
import org.ravin.models.Cliente;
import org.ravin.services.interfaces.IClienteService;

import java.util.List;
import java.util.Optional;

public class ClienteService implements IClienteService{

    // Injeção de dependência parcial - lista por Singleton
    private final IClienteRepositorioLista clienteRepositorio;
    public ClienteService(){
        clienteRepositorio = ListasDados.getInstance().getClienteRepositorio();
    }

    @Override
    public void inserir(Cliente cliente) {
        clienteRepositorio.inserir(cliente);
    }

    @Override
    public Optional<Cliente> recuperarPorId(int id) {
        return clienteRepositorio.recuperarPorId(id);
    }

    @Override
    public List<Cliente> recuperarTodos() {
        return clienteRepositorio.recuperarTodos();
    }


    @Override
    public void atualizar(Cliente cliente) {
        clienteRepositorio.atualizar(cliente);
    }

    @Override
    public boolean remover(Cliente cliente) {
        try{
            clienteRepositorio.remover(cliente);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Optional<Cliente> recuperarPorCpf(String cpf) {

        return clienteRepositorio.recuperarClientePorCpf(cpf);
    }
    
}
