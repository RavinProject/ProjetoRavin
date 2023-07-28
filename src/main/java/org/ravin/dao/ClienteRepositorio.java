package org.ravin.dao;

import org.ravin.dao.interfaces.IClienteRepositorio;
import org.ravin.models.Cliente;

import java.util.List;
import java.util.Optional;

public class ClienteRepositorio implements IClienteRepositorio {

    private final List<Cliente> listaClientes;

    public ClienteRepositorio(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }
    
    @Override
    public void inserir(Cliente cliente) {
        if (cliente.getId() == 0) {
            cliente.setId(geraProximoId());
        }
        pegarLista().add(cliente);
    }
        
    @Override
    public Optional<Cliente> recuperarPorId(int id) {
        for (Cliente cliente : pegarLista()) {
            if (cliente.getId() == id) {
                return Optional.of(cliente);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Cliente> pegarLista() {
        return listaClientes;
    }

    @Override
    public int geraProximoId() {
        return IClienteRepositorio.super.geraProximoId();
    }


    @Override
    public void atualizar(Cliente clienteAtualizado) {
        for (int i = 0; i < pegarLista().size(); i++) {
            if (pegarLista().get(i).getId() == clienteAtualizado.getId()) {
                pegarLista().set(i, clienteAtualizado);
                break;
            }
        }
    }

    @Override
    public void remover(Cliente cliente) {
        pegarLista().remove(cliente); // Remove o cliente da lista
    }

    @Override
    public void removerPorId(int id) {
        // Itera pela lista e remove o cliente com o ID fornecido
        pegarLista().removeIf(cliente -> cliente.getId() == id);
    }

    @Override
    public Optional<Cliente> recuperarClientePorCpf(String cpf) {
        // Itera pela lista e tenta encontrar um cliente com o CPF fornecido
        for (Cliente cliente : pegarLista()) {
            if (cliente.getCpf().equals(cpf)) {
                return Optional.of(cliente);
            }
        }
        return Optional.empty();
    }
}
