package dao.interfaces;

import java.util.List;

public interface IRepositorio<T> {

    // Create
    void inserir(T object);

    // Read
    List<T> pegarLista();
    T recuperarPorId(int id);

    // Update
    void atualizar(T object);

    // Delete
    void remover(T object);
    void removerPorId(int id);
}
