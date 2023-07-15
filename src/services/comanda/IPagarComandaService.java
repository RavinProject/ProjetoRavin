package services.comanda;

import utils.exceptions.EntidadeNaoEncontradaException;

public interface IPagarComandaService {
    boolean pagarComanda(String codigo) throws EntidadeNaoEncontradaException;
}
