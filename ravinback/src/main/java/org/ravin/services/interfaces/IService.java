package org.ravin.services.interfaces;

import java.util.List;
import java.util.Optional;

public interface IService <T>{
    void inserir(T objeto);
    Optional<T> recuperarPorId(int id);
    List<T> pegarLista();
    void atualizar(T objeto);
    boolean remover(T objeto);
}
