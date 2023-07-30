package org.ravin.services;

import org.ravin.dao.ListasDados;
import org.ravin.dao.interfaces.IProdutoRepositorioLista;
import org.ravin.models.Produto;
import org.ravin.services.interfaces.IProdutoService;

import java.util.List;
import java.util.Optional;

public class ProdutoService implements IProdutoService {

    // Injeção de dependência parcial - lista por Singleton
    private final IProdutoRepositorioLista produtoRepositorio;
    public ProdutoService(){
        produtoRepositorio = ListasDados.getInstance().getProdutoRepositorio();
    }

    @Override
    public void inserir(Produto produto) {
        produtoRepositorio.inserir(produto);
    }

    @Override
    public Optional<Produto> recuperarPorId(int id) {
        return Optional.empty();
    }

    @Override
    public List<Produto> recuperarTodos() {
        return produtoRepositorio.recuperarTodos();
    }

    @Override
    public void atualizar(Produto produto) {

    }

    @Override
    public boolean remover(Produto produto) {
        return false;
    }

    @Override
    public Optional<Produto> recuperarPorCodigo(String codigo) {
        return Optional.empty();
    }
}
