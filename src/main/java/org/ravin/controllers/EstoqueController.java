package org.ravin.controllers;

import org.ravin.controllers.interfaces.IEstoqueController;
import org.ravin.models.Estoque;
import org.ravin.services.interfaces.IEstoqueService;
import org.ravin.utils.exceptions.EntidadeNaoEncontradaException;

import java.util.List;
import java.util.Optional;

public class EstoqueController implements IEstoqueController {

    // Injeção de dependência
    private final IEstoqueService estoqueService;
    public EstoqueController(IEstoqueService estoqueService){
        this.estoqueService = estoqueService;
    }

    public boolean estoqueJaCadastrado(String codigo){
        Optional<Estoque> estoque = estoqueService.recuperarPorCodigo(codigo);
        if (estoque.isPresent()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void inserir(Estoque objeto) {
        estoqueService.inserir(objeto);
    }

    @Override
    public Estoque recuperarPorId(int id) throws EntidadeNaoEncontradaException{
        Optional<Estoque> estoque = estoqueService.recuperarPorId(id);
        if (estoque.isPresent()) {
            return estoque.get();
        } else {
            throw new EntidadeNaoEncontradaException("Estoque não encontrado para o ID: " + id);
        }
    }

    @Override
    public List<Estoque> pegarLista() {
        return estoqueService.pegarLista();
    }

    @Override
    public void atualizar(Estoque estoque) {
        estoqueService.atualizar(estoque);
    }

    @Override
    public boolean remover(Estoque estoque) {
        estoqueService.remover(estoque);
        return true;
    }

    @Override
    public Estoque recuperarPorCodigo(String codigo) throws EntidadeNaoEncontradaException{
        Optional<Estoque> estoque = estoqueService.recuperarPorCodigo(codigo);
        if (estoque.isPresent()) {
            return estoque.get();
        } else {
            throw new EntidadeNaoEncontradaException("Estoque não encontrado para o Produto com código: " + codigo);
        }
    }

}
