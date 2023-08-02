/**
 * Interface para definir a funcionalidade básica de um serviço.
 *
 * <p>Esta interface define as operações básicas de CRUD (criar, ler, atualizar e deletar) para um objeto genérico.
 * Ela pode ser implementada por qualquer serviço que necessite dessas operações.
 *
 * @param <T> o tipo do objeto a ser gerenciado pelo serviço.
 */
package org.ravin.services.interfaces;

import java.util.List;
import java.util.Optional;

public interface IService <T>{

    void inserir(T t);

    Optional<T> recuperarPorId(int id);


    List<T> recuperarTodos();


    void atualizar(T t);


    boolean remover(T t);
}
