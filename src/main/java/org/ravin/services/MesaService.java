package org.ravin.services;

import org.ravin.dao.ListasDados;
import org.ravin.dao.MesaRepositorio;
import org.ravin.dao.PedidoRepositorio;
import org.ravin.dao.interfaces.IMesaRepositorio;
import org.ravin.models.Mesa;
import org.ravin.services.interfaces.IMesaService;

import java.util.List;
import java.util.Optional;

public class MesaService implements IMesaService {

    // Injeção de dependência parcial - lista por Singleton
    private IMesaRepositorio mesaRepositorio;
    public MesaService(){ this.mesaRepositorio = ListasDados.getInstance().getMesaRepositorio(); }
    @Override
    public void inserir(Mesa objeto) {

    }

    @Override
    public Optional<Mesa> recuperarPorId(int id) {
        return Optional.empty();
    }

    @Override
    public List<Mesa> pegarLista() {
        return null;
    }

    @Override
    public void atualizar(Mesa objeto) {

    }

    @Override
    public boolean remover(Mesa objeto) {
        return false;
    }
}
