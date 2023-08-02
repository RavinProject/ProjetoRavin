package org.ravin.dao;

import org.ravin.dao.interfaces.IProdutoRepositorioLista;
import org.ravin.models.Produto;

import java.util.List;
import java.util.Optional;

public class ProdutoRepositorioLista implements IProdutoRepositorioLista {

    private final List<Produto> listaProdutos;

    public ProdutoRepositorioLista(List<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    @Override
    public void inserir(Produto produto) {
        if (produto.getId() == 0) {
            produto.setId(geraProximoId(listaProdutos));
        }
        listaProdutos.add(produto);
    }

    @Override
    public List<Produto> recuperarTodos() {
        return listaProdutos;
    }

    @Override
    public Optional<Produto> recuperarPorId(int id) {
        for (Produto produto : listaProdutos) {
            if (produto.getId() == id) {
                return Optional.of(produto);
            }
        }
        return Optional.empty();
    }

    @Override
    public void atualizar(Produto produtoAtualizado) {
        for (int i = 0; i < listaProdutos.size(); i++) {
            if (listaProdutos.get(i).getId() == produtoAtualizado.getId()) {
                listaProdutos.set(i, produtoAtualizado);
                break;
            }
        }
    }

    @Override
    public void remover(Produto produto) {
        listaProdutos.remove(produto);
    }

    @Override
    public void removerPorId(int id) {
        listaProdutos.removeIf(produto -> produto.getId() == id);
    }

    @Override
    public Optional<Produto> recuperarProdutoPorCodigo(String codigo) {
        for (Produto produto : listaProdutos) {
            if (produto.getCodigo().equals(codigo)) {
                return Optional.of(produto);
            }
        }
        return Optional.empty();
    }
}
