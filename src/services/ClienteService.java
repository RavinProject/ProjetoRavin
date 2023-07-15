package services;

import java.util.List;
import java.util.Optional;

import dao.ListasDados;
import dao.interfaces.IClienteRepositorio;
import models.Cliente;
import services.interfaces.IClienteService;

public class ClienteService implements IClienteService{

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
    public void atualizar(Cliente cliente) {
        clienteRepositorio.atualizar(cliente);
    }

    @Override
    public boolean remover(Cliente cliente) {
        clienteRepositorio.remover(cliente);
        return true;
    }

    @Override
    public Optional<Cliente> recuperarPorCpf(String cpf) {
        return clienteRepositorio.recuperarPorCpf(cpf);
    }
    
}
