package org.ravin.controllers.interfaces;

import java.util.List;

import org.ravin.utils.exceptions.EntidadeNaoEncontradaException;

public interface IController<T> {
    void inserir(T objeto);
    T recuperarPorId(int id) throws EntidadeNaoEncontradaException;
    List<T> pegarLista();
    void atualizar(T objeto);
    boolean remover(T objeto);
}
