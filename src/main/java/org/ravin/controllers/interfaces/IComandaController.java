package org.ravin.controllers.interfaces;

import org.ravin.models.Comanda;
import org.ravin.utils.exceptions.EntidadeNaoEncontradaException;

public interface IComandaController extends IController<Comanda> {
    void processarComanda(Comanda comanda) throws EntidadeNaoEncontradaException;
}
