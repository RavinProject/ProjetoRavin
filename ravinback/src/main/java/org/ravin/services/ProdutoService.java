package org.ravin.services;

import org.ravin.dao.ListasDados;
import org.ravin.dao.ProdutoRepositorio;
import org.ravin.dao.interfaces.IEstoqueRepositorio;
import org.ravin.dao.interfaces.IProdutoRepositorio;
import org.ravin.models.Produto;
import org.ravin.services.interfaces.IProdutoService;

import java.util.List;
import java.util.Optional;

public class ProdutoService implements IProdutoService {
    private final IProdutoRepositorio produtoRepositorio;
    public ProdutoService(){
        produtoRepositorio = ListasDados.getInstance().getProdutoRepositorio();
    }

    @Override
    public void inserir(Produto objeto) {

    }

    @Override
    public Optional<Produto> recuperarPorId(int id) {
        return Optional.empty();
    }

    @Override
    public List<Produto> pegarLista() {
        return null;
    }

    @Override
    public void atualizar(Produto objeto) {

    }

    @Override
    public boolean remover(Produto objeto) {
        return false;
    }

    @Override
    public Optional<Produto> recuperarPorCodigo(String codigo) {
        return Optional.empty();
    }
}
