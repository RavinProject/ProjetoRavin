package controllers.interfaces;

import models.Comanda;
import utils.exceptions.EntidadeNaoEncontradaException;

public interface IComandaController extends IController<Comanda> {
    void processarComanda(Comanda comanda) throws EntidadeNaoEncontradaException;
}
