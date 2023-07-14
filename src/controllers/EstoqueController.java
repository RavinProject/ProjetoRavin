package controllers;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import controllers.interfaces.IEstoqueController;
import dao.interfaces.IEstoqueRepositorio;
import models.Estoque;

public class EstoqueController implements IEstoqueController {

    private final IEstoqueRepositorio estoqueRepositorio;

    public EstoqueController(IEstoqueRepositorio estoqueRepositorio){
        this.estoqueRepositorio = estoqueRepositorio;
    }

    public boolean produtoJaCadastrado(String codigo){
        try{
            recuperarPorCodigo(codigo);
            return true;
        }catch(NoSuchElementException e){
            return false;
        }
    }

    @Override
    public void inserir(Estoque objeto) {
        estoqueRepositorio.inserir(objeto);
    }

    @Override
    public Estoque recuperarPorId(int id) throws NoSuchElementException{
        Optional<Estoque> estoque = estoqueRepositorio.recuperarPorId(id);
        if (estoque.isPresent()) {
            return estoque.get();
        } else {
            throw new NoSuchElementException("Estoque não encontrado para o ID: " + id);
        }
    }

    @Override
    public List<Estoque> pegarLista() {
        return estoqueRepositorio.pegarLista();
    }

    @Override
    public void atualizar(Estoque estoque) {
        estoqueRepositorio.atualizar(estoque);
    }

    @Override
    public boolean remover(Estoque estoque) {
        estoqueRepositorio.remover(estoque);
        return true;
    }

    @Override
    public Estoque recuperarPorCodigo(String codigo) throws NoSuchElementException{
        Optional<Estoque> estoque = estoqueRepositorio.recuperarPorCodigo(codigo);
        if (estoque.isPresent()) {
            return estoque.get();
        } else {
            throw new NoSuchElementException("Estoque não encontrado para o Produto com código: " + codigo);
        }
    }

}
