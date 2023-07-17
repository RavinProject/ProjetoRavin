package controllers;

import controllers.interfaces.IComandaController;
import models.Comanda;
import services.comanda.IPagarComandaService;
import utils.exceptions.EntidadeNaoEncontradaException;

import java.util.List;

public class ComandaController implements IComandaController {

    private final IPagarComandaService comandaService;

    public ComandaController(IPagarComandaService comandaService) {
        this.comandaService = comandaService;
    }

    @Override
    public void processarComanda(Comanda comanda) throws EntidadeNaoEncontradaException {
        comandaService.pagarComanda(comanda.getCodigo());
    }

    @Override
    public void inserir(Comanda objeto) {

    }

    @Override
    public Comanda recuperarPorId(int id) {
        return null;
    }

    @Override
    public List<Comanda> pegarLista() {
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
