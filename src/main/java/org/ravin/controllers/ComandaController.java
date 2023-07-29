package org.ravin.controllers;

import org.ravin.controllers.interfaces.IComandaController;
import org.ravin.models.Comanda;
import org.ravin.services.comanda.interfaces.IComandaService;
import org.ravin.services.comanda.interfaces.IPagarComandaService;
import org.ravin.utils.exceptions.EntidadeNaoEncontradaException;

import java.util.List;

public class ComandaController implements IComandaController {

    // Injeção de dependência
    private final IComandaService comandaService;
    private final IPagarComandaService pagarComandaService;

    public ComandaController(IPagarComandaService pagarComandaService, IComandaService comandaService) {
        this.pagarComandaService = pagarComandaService;
        this.comandaService = comandaService;
    }

    @Override
    public void processarComanda(Comanda comanda) throws EntidadeNaoEncontradaException {
        pagarComandaService.pagarComanda(comanda.getCodigo());
    }

    @Override
    public void inserir(Comanda comanda) {
        comandaService.inserir(comanda);
    }

    @Override
    public Comanda recuperarPorId(int id) throws EntidadeNaoEncontradaException {
        throw new EntidadeNaoEncontradaException("ComandaController::recuperarPorID(int id) NÃO IMPLEMENTADA");
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
