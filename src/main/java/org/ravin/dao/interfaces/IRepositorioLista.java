package org.ravin.dao.interfaces;

import org.ravin.utils.interfaces.IGeradorId;

import java.util.List;
import java.util.Optional;

public interface IRepositorioLista<T>  extends IGeradorId<T> {

    // Create
    void inserir(T object);

    // Read
    List<T> recuperarTodos();
    Optional<T> recuperarPorId(int id);

    // Update
    void atualizar(T object);

    // Delete
    void remover(T object);
    void removerPorId(int id);

}
