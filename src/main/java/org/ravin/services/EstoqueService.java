package org.ravin.services;

import org.ravin.dao.ListasDados;
import org.ravin.dao.interfaces.IEstoqueRepositorioLista;
import org.ravin.dao.interfaces.IProdutoRepositorioLista;
import org.ravin.models.Estoque;
import org.ravin.services.interfaces.IEstoqueService;

import java.util.List;
import java.util.Optional;

public class EstoqueService implements IEstoqueService {

    // Injeção de dependência parcial - lista por Singleton
    private final IEstoqueRepositorioLista estoqueRepositorio;
    private final IProdutoRepositorioLista produtoRepositorio;
    public EstoqueService(){
        estoqueRepositorio = ListasDados.getInstance().getEstoqueRepositorio();
        produtoRepositorio = ListasDados.getInstance().getProdutoRepositorio();
    }

    // Inserção acontece simultaneamente em Produto e Estoque
    @Override
    public void inserir(Estoque estoque) {
        produtoRepositorio.inserir(estoque.getProduto());
        estoqueRepositorio.inserir(estoque);
    }

    @Override
    public Optional<Estoque> recuperarPorId(int id) {
        return estoqueRepositorio.recuperarPorId(id);
    }

    @Override
    public List<Estoque> recuperarTodos() {
        return estoqueRepositorio.recuperarTodos();
    }

    // Atualização acontece simultaneamente em Produto e Estoque
    @Override
    public void atualizar(Estoque estoque) {
        produtoRepositorio.atualizar(estoque.getProduto());
        estoqueRepositorio.atualizar(estoque);
    }

    @Override
    public boolean remover(Estoque estoque) {
        try{
            estoqueRepositorio.remover(estoque);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Optional<Estoque> recuperarPorCodigo(String codigo) {
        return estoqueRepositorio.recuperarEstoquePorCodigo(codigo);
    }
}
