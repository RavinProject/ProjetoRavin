package controllers;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import controllers.interfaces.IProdutoController;
import dao.interfaces.IProdutoRepositorio;
import models.Produto;

public class ProdutoController implements IProdutoController {

    private final IProdutoRepositorio produtoRepositorio;

    public ProdutoController(IProdutoRepositorio produtoRepositorio){
        this.produtoRepositorio = produtoRepositorio;
    }

    @Override
    public void atualizar(Produto produto) {
        produtoRepositorio.atualizar(produto);
    }

    @Override
    public boolean remover(Produto produto) {
        produtoRepositorio.remover(produto);
        return true;
    }

    @Override
    public void inserir(Produto produto) {
        produtoRepositorio.inserir(produto);
    }

    @Override
    public Produto recuperarPorId(int id) throws NoSuchElementException{
        Optional<Produto> produto = produtoRepositorio.recuperarPorId(id);
        if (produto.isPresent()) {
            return produto.get();
        } else {
            throw new NoSuchElementException("Produto não encontrado com o id: " + id);
        }
    }

    @Override
    public Produto recuperarPorCodigo(String codigo) throws NoSuchElementException{
        Optional<Produto> produto = produtoRepositorio.recuperarPorCodigo(codigo);
        if (produto.isPresent()) {
            return produto.get();
        } else {
            throw new NoSuchElementException("Produto não encontrado com o Código: " + codigo);
        }
    }

    @Override
    public List<Produto> pegarLista() {
        return produtoRepositorio.pegarLista();
    }
    
}
