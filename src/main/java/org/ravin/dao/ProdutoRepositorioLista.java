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
        pegarLista().add(produto);
    }

    @Override
    public List<Produto> pegarLista() {
        return listaProdutos;
    }

    @Override
    public Optional<Produto> recuperarPorId(int id) {
        for (Produto produto : pegarLista()) {
            if (produto.getId() == id) {
                return Optional.of(produto);
            }
        }
        return Optional.empty();
    }

    @Override
    public void atualizar(Produto produtoAtualizado) {
        for (int i = 0; i < pegarLista().size(); i++) {
            if (pegarLista().get(i).getId() == produtoAtualizado.getId()) {
                pegarLista().set(i, produtoAtualizado);
                break;
            }
        }
    }

    @Override
    public void remover(Produto produto) {
        pegarLista().remove(produto);
    }

    @Override
    public void removerPorId(int id) {
        pegarLista().removeIf(produto -> produto.getId() == id);
    }

    @Override
    public Optional<Produto> recuperarProdutoPorCodigo(String codigo) {
        for (Produto produto : pegarLista()) {
            if (produto.getCodigo().equals(codigo)) {
                return Optional.of(produto);
            }
        }
        return Optional.empty();
    }
}