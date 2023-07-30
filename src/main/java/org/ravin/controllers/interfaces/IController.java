/**
 * Interface para definir a funcionalidade básica de um controlador.
 *
 * <p>Esta interface define as operações básicas de CRUD (criar, ler, atualizar e deletar) para um objeto genérico.
 * Ela pode ser implementada por qualquer controlador que necessite dessas operações.
 *
 * @param <T> o tipo do objeto a ser gerenciado pelo controlador.
 */
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
