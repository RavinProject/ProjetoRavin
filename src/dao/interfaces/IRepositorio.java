package dao.interfaces;

import java.util.List;
import java.util.Optional;

public interface IRepositorio<T> {

    // Create
    void inserir(T object);

    // Read
    List<T> pegarLista();
    Optional<T> recuperarPorId(int id);

    // Update
    void atualizar(T object);

    // Delete
    void remover(T object);
    void removerPorId(int id);

    // Gera ID
    int geraProximoId();
}
