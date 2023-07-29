package org.ravin.services;

import org.ravin.dao.ListasDados;
import org.ravin.dao.interfaces.IEstoqueRepositorioLista;
import org.ravin.models.Estoque;
import org.ravin.services.interfaces.IEstoqueService;

import java.util.List;
import java.util.Optional;

public class EstoqueService implements IEstoqueService {

    // Injeção de dependência parcial - lista por Singleton
    private final IEstoqueRepositorioLista estoqueRepositorio;
    public EstoqueService(){
        estoqueRepositorio = ListasDados.getInstance().getEstoqueRepositorio();
    }

    @Override
    public void inserir(Estoque estoque) {
        estoqueRepositorio.inserir(estoque);
    }

    @Override
    public Optional<Estoque> recuperarPorId(int id) {
        return estoqueRepositorio.recuperarPorId(id);
    }

    @Override
    public List<Estoque> recuperarTodos() {

        return estoqueRepositorio.pegarLista();
    }

    @Override
    public void atualizar(Estoque estoque) {
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
