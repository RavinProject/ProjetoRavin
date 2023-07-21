package org.ravin.services;

import org.ravin.dao.ListasDados;
import org.ravin.dao.interfaces.IClienteRepositorio;
import org.ravin.models.Cliente;
import org.ravin.services.interfaces.IClienteService;

import java.util.List;
import java.util.Optional;

public class ClienteService implements IClienteService{

    // Injeção de dependência parcial - lista por Singleton
    private final IClienteRepositorio clienteRepositorio;
    public ClienteService(){
        clienteRepositorio = ListasDados.getInstance().getClienteRepositorio();
    }

    @Override
    public void inserir(Cliente cliente) {
        if (cliente.getId() == 0) {
            cliente.setId(geraProximoId());
        }
        clienteRepositorio.inserir(cliente);
    }

    public int geraProximoId() {
        int maiorId = 0;
        for (Cliente cliente : pegarLista()) {
            if (cliente.getId() > maiorId) {
                maiorId = cliente.getId();
            }
        }
        return maiorId + 1;
    }

    @Override
    public Optional<Cliente> recuperarPorId(int id) {
        return clienteRepositorio.recuperarPorId(id);
    }

    @Override
    public List<Cliente> pegarLista() {
        return clienteRepositorio.pegarLista();
    }

    @Override
    public int getId(Cliente cliente) {
        return cliente.getId();
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
