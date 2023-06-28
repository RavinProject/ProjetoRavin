package controllers;

import java.util.List;

public abstract class Controller<T> {
    public abstract void atualizar(T objeto);
    public abstract boolean remover(T objeto);
    public abstract void inserir(T objeto);
    public abstract T recuperar(int id);
    public abstract List<T> pegarLista();
}
