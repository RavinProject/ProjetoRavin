package dao;

import dao.interfaces.IClienteRepositorio;
import models.Cliente;

import java.util.List;
import java.util.Optional;

public class ClienteRepositorio implements IClienteRepositorio {

    private final List<Cliente> listaClientes;

    public ClienteRepositorio(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    @Override
    public void inserir(Cliente cliente) {
        listaClientes.add(cliente); // Adiciona o cliente na lista
    }

    @Override
    public List<Cliente> pegarLista() {
        return listaClientes; // Retorna a lista de clientes
    }

    // TODO testar
    @Override
    public Optional<Cliente> recuperarPorId(int id) {
        // Itera pela lista e tenta encontrar um cliente com o ID fornecido
        for (Cliente cliente : listaClientes) {
            if (cliente.getId() == id) {
                return Optional.of(cliente);
            }
        }
        return Optional.empty(); // Retorna um Optional vazio se não encontrar
    }

    // TODO testar
    @Override
    public void atualizar(Cliente clienteAtualizado) {
        // Itera pela lista e atualiza o cliente com o mesmo ID
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

    @Override
    public Optional<Cliente> recuperarPorCpf(String cpf) {
        // Itera pela lista e tenta encontrar um cliente com o CPF fornecido
        for (Cliente cliente : listaClientes) {
            if (cliente.getCpf().equals(cpf)) {
                return Optional.of(cliente);
            }
        }
        return Optional.empty(); // Retorna um Optional vazio se não encontrar
    }
}
