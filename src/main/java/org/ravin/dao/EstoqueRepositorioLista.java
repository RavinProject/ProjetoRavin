package org.ravin.dao;

import org.ravin.dao.interfaces.IEstoqueRepositorioLista;
import org.ravin.models.Estoque;

import java.util.List;
import java.util.Optional;

public class EstoqueRepositorioLista implements IEstoqueRepositorioLista {

    private final List<Estoque> listaEstoque;

    public EstoqueRepositorioLista(List<Estoque> listaEstoque) {
        this.listaEstoque = listaEstoque;
    }

    @Override
    public void inserir(Estoque estoque) {
        if (estoque.getId() == 0) {
            estoque.setId(geraProximoId(listaEstoque));
        }
        listaEstoque.add(estoque);
    }

    @Override
    public List<Estoque> recuperarTodos() {
        return listaEstoque;
    }

    @Override
    public Optional<Estoque> recuperarPorId(int id) {
        for (Estoque estoque : listaEstoque) {
            if (estoque.getId() == id) {
                return Optional.of(estoque);
            }
        }
        return Optional.empty();
    }

    @Override
    public void atualizar(Estoque estoqueAtualizado) {
        for (int i = 0; i < listaEstoque.size(); i++) {
            if (listaEstoque.get(i).getId() == estoqueAtualizado.getId()) {
                listaEstoque.set(i, estoqueAtualizado);
                break;
            }
        }
    }

    @Override
    public void remover(Estoque estoque) {
        listaEstoque.remove(estoque);
    }

    @Override
    public void removerPorId(int id) {
        listaEstoque.removeIf(estoque -> estoque.getId() == id);
    }

    @Override
    public Optional<Estoque> recuperarEstoquePorCodigo(String codigo) {
        for (Estoque estoque : listaEstoque) {
            if (estoque.getProduto().getCodigo().equalsIgnoreCase(codigo)) {
                return Optional.of(estoque);
            }
        }
        return Optional.empty();
    }

    @Override
    public int getId(Estoque estoque) {
        return IEstoqueRepositorioLista.super.getId(estoque);
    }
}
