package org.ravin.controllers;

import org.ravin.controllers.interfaces.IProdutoController;
import org.ravin.models.Produto;
import org.ravin.services.interfaces.IProdutoService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class ProdutoController implements IProdutoController {

    // Injeção de dependência
    private final IProdutoService produtoService;
    public ProdutoController(IProdutoService produtoService){
        this.produtoService = produtoService;
    }

    @Override
    public void atualizar(Produto produto) {
        produtoService.atualizar(produto);
    }

    @Override
    public boolean remover(Produto produto) {
        produtoService.remover(produto);
        return true;
    }

    @Override
    public void inserir(Produto produto) {
        produtoService.inserir(produto);
    }

    @Override
    public Produto recuperarPorId(int id) throws NoSuchElementException{
        Optional<Produto> produto = produtoService.recuperarPorId(id);
        if (produto.isPresent()) {
            return produto.get();
        } else {
            throw new NoSuchElementException("Produto não encontrado com o id: " + id);
        }
    }

    @Override
    public Produto recuperarPorCodigo(String codigo) throws NoSuchElementException{
        Optional<Produto> produto = produtoService.recuperarPorCodigo(codigo);
        if (produto.isPresent()) {
            return produto.get();
        } else {
            throw new NoSuchElementException("Produto não encontrado com o Código: " + codigo);
        }
    }

    @Override
    public List<Produto> pegarLista() {
        return produtoService.pegarLista();
    }
    
}
