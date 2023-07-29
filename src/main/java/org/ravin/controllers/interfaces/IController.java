package org.ravin.controllers.interfaces;

import org.ravin.utils.exceptions.EntidadeNaoEncontradaException;

import java.util.List;

public interface IController<T> {
    void inserir(T objeto);
    T recuperarPorId(int id) throws EntidadeNaoEncontradaException;
    List<T> recuperarTodos();
    void atualizar(T objeto) throws EntidadeNaoEncontradaException;
    boolean remover(T objeto) throws EntidadeNaoEncontradaException;
}
