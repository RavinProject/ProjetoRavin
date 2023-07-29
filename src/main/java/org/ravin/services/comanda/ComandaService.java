package org.ravin.services.comanda;

import org.ravin.dao.ListasDados;
import org.ravin.dao.interfaces.IComandaRepositorioLista;
import org.ravin.models.Comanda;
import org.ravin.services.comanda.interfaces.IComandaService;

import java.util.List;
import java.util.Optional;

public class ComandaService implements IComandaService {

    private final IComandaRepositorioLista comandaRepository;

    public ComandaService() {
        this.comandaRepository = ListasDados.getInstance().getComandaRepositorio();
    }

    @Override
    public void inserir(Comanda comanda) {
        comandaRepository.inserir(comanda);
    }

    @Override
    public Optional<Comanda> recuperarPorId(int id) {
        return Optional.empty();
    }

    @Override
    public List<Comanda> recuperarTodos() {
        return null;
    }

    @Override
    public void atualizar(Comanda objeto) {

    }

    @Override
    public boolean remover(Comanda objeto) {
        return false;
    }
}
