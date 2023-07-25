package org.ravin.services;

import org.ravin.dao.ListasDados;
import org.ravin.dao.interfaces.IEstoqueRepositorio;
import org.ravin.models.Cliente;
import org.ravin.models.Estoque;
import org.ravin.services.interfaces.IEstoqueService;

import java.util.List;
import java.util.Optional;

public class EstoqueService implements IEstoqueService {

    private final IEstoqueRepositorio estoqueRepositorio;
    public EstoqueService(){
        estoqueRepositorio = ListasDados.getInstance().getEstoqueRepositorio();
    }

    @Override
    public void inserir(Estoque estoque) {
        if (estoque.getId() == 0) {
            estoque.setId(geraProximoId());
        }
        estoqueRepositorio.inserir(estoque);
    }

    @Override
    public Optional<Estoque> recuperarPorId(int id) {
        return estoqueRepositorio.recuperarPorId(id);
    }

    @Override
    public List<Estoque> pegarLista() {

        return estoqueRepositorio.pegarLista();
    }

    @Override
    public int getId(Estoque estoque) {
        return estoque.getId();
    }

    @Override
    public int geraProximoId() {
        return IEstoqueService.super.geraProximoId();
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
        return estoqueRepositorio.recuperarComandaPorCodigo(codigo);
    }
}
