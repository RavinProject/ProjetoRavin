package org.ravin.services.comanda;

import org.ravin.dao.ComandaRepositorio;
import org.ravin.dao.ListasDados;
import org.ravin.dao.interfaces.IClienteRepositorio;
import org.ravin.dao.interfaces.IComandaRepositorio;
import org.ravin.models.Comanda;
import org.ravin.services.comanda.interfaces.IComandaService;

import java.util.List;
import java.util.Optional;

public class ComandaService implements IComandaService {
    private final IComandaRepositorio comandaRepository;

    public ComandaService() {
        this.comandaRepository = ListasDados.getInstance().getComandaRepositorio();
    }

    @Override
    public void inserir(Comanda objeto) {

    }

    @Override
    public Optional<Comanda> recuperarPorId(int id) {
        return Optional.empty();
    }

    @Override
    public List<Comanda> pegarLista() {
        return null;
    }

    @Override
    public int getId(Comanda comanda) {
        return comanda.getId();
    }

    @Override
    public int geraProximoId() {
        return IComandaService.super.geraProximoId();
    }

    @Override
    public void atualizar(Comanda objeto) {

    }

    @Override
    public boolean remover(Comanda objeto) {
        return false;
    }
}
