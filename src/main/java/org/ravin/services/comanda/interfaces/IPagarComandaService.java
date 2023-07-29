package org.ravin.services.comanda.interfaces;

import org.ravin.utils.exceptions.EntidadeNaoEncontradaException;

public interface IPagarComandaService {
    void pagarComanda(String codigo) throws EntidadeNaoEncontradaException;
}
