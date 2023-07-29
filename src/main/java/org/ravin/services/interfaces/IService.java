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
