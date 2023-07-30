package org.ravin.services;

import org.ravin.dao.ListasDados;
import org.ravin.dao.interfaces.IMesaRepositorioLista;
import org.ravin.models.Mesa;
import org.ravin.services.interfaces.IMesaService;

import java.util.List;
import java.util.Optional;

public class MesaService implements IMesaService {
    private final IMesaRepositorioLista mesaRepositorio;
    public MesaService(){ this.mesaRepositorio = ListasDados.getInstance().getMesaRepositorio(); }

    @Override
    public void inserir(Mesa mesa) {
        mesaRepositorio.inserir(mesa);
    }

    @Override
    public Optional<Mesa> recuperarPorId(int id) {
        return mesaRepositorio.recuperarPorId(id);
    }

    @Override
    public Optional<Mesa> recuperarPorCodigo(String codigo) {
        return mesaRepositorio.recuperarPorCodigo(codigo);
    }

    @Override
    public List<Mesa> recuperarTodos() {
        return mesaRepositorio.recuperarTodos();
    }

    @Override
    public void atualizar(Mesa mesa) {
        mesaRepositorio.atualizar(mesa);
    }

    @Override
    public boolean remover(Mesa mesa) {
        try{
            mesaRepositorio.remover(mesa);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
