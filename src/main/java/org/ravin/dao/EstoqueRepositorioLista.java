package org.ravin.dao;

import org.ravin.dao.interfaces.IEstoqueRepositorioLista;
import org.ravin.dao.interfaces.IProdutoRepositorioLista;
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
        // insiro o produto na lista de produtos
        IProdutoRepositorioLista produtoRepositorio = ListasDados.getInstance().getProdutoRepositorio();
        produtoRepositorio.inserir(estoque.getProduto());
        // insiro o estoque na lista de estoque
        if (estoque.getId() == 0) {
            estoque.setId(geraProximoId(listaEstoque));
        }
        pegarLista().add(estoque);
    }

    @Override
    public List<Estoque> pegarLista() {
        return listaEstoque;
    }

    @Override
    public Optional<Estoque> recuperarPorId(int id) {
        for (Estoque estoque : pegarLista()) {
            if (estoque.getId() == id) {
                return Optional.of(estoque);
            }
        }
        return Optional.empty();
    }

    @Override
    public void atualizar(Estoque estoqueAtualizado) {
        // atualizo o produto na lista de produtos
        IProdutoRepositorioLista produtoRepositorio = ListasDados.getInstance().getProdutoRepositorio();
        produtoRepositorio.atualizar(estoqueAtualizado.getProduto());
        // atualizo o estoque
        for (int i = 0; i < pegarLista().size(); i++) {
            if (pegarLista().get(i).getId() == estoqueAtualizado.getId()) {
                pegarLista().set(i, estoqueAtualizado);
                break;
            }
        }
    }

    @Override
    public void remover(Estoque estoque) {
        pegarLista().remove(estoque);
    }

    @Override
    public void removerPorId(int id) {
        pegarLista().removeIf(estoque -> estoque.getId() == id);
    }

    @Override
    public Optional<Estoque> recuperarEstoquePorCodigo(String codigo) {
        for (Estoque estoque : pegarLista()) {
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
