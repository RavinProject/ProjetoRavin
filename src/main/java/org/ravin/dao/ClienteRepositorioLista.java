package org.ravin.dao;

import org.ravin.dao.interfaces.IClienteRepositorioLista;
import org.ravin.models.Cliente;

import java.util.List;
import java.util.Optional;

public class ClienteRepositorioLista implements IClienteRepositorioLista {

    private final List<Cliente> listaClientes;

    public ClienteRepositorioLista(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }
    
    @Override
    public void inserir(Cliente cliente) {
        if (cliente.getId() == 0) {
            cliente.setId(geraProximoId(listaClientes));
        }
        listaClientes.add(cliente);
    }
        
    @Override
    public Optional<Cliente> recuperarPorId(int id) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getId() == id) {
                return Optional.of(cliente);
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<Cliente> recuperarClientePorCpf(String cpf) {
        // Itera pela lista e tenta encontrar um cliente com o CPF fornecido
        for (Cliente cliente : listaClientes) {
            if (cliente.getCpf().equals(cpf)) {
                return Optional.of(cliente);
            }
        }
        return Optional.empty();
    }


    @Override
    public List<Cliente> recuperarTodos() {
        return listaClientes;
    }


    @Override
    public void atualizar(Cliente clienteAtualizado) {
        for (int i = 0; i < listaClientes.size(); i++) {
            if (listaClientes.get(i).getId() == clienteAtualizado.getId()) {
                listaClientes.set(i, clienteAtualizado);
                break;
            }
        }
    }

    @Override
    public void remover(Cliente cliente) {
        listaClientes.remove(cliente); // Remove o cliente da lista
    }

    @Override
    public void removerPorId(int id) {
        // Itera pela lista e remove o cliente com o ID fornecido
        listaClientes.removeIf(cliente -> cliente.getId() == id);
    }
}
