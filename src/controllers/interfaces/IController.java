package controllers.interfaces;

import java.util.List;

public interface IController<T> {
    void inserir(T objeto);
    T recuperarPorId(int id);
    List<T> pegarLista();
    void atualizar(T objeto);
    boolean remover(T objeto);
}
