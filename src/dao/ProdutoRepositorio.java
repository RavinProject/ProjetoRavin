package dao;

import dao.interfaces.IProdutoRepositorio;
import models.Produto;

import java.util.List;
import java.util.Optional;

public class ProdutoRepositorio implements IProdutoRepositorio {

    private List<Produto> listaProdutos;

    public ProdutoRepositorio(List<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    @Override
    public void inserir(Produto produto) {
        listaProdutos.add(produto);
    }

    @Override
    public List<Produto> pegarLista() {
        return listaProdutos;
    }

    @Override
    public Optional<Produto> recuperarPorId(int id) {
        return Optional.empty();
    }

    @Override
    public void atualizar(Produto object) {

    }

    @Override
    public void remover(Produto object) {

    }

    @Override
    public void removerPorId(int id) {

    }
}
