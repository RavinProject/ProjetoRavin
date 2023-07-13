package dao;

import dao.interfaces.IEstoqueRepositorio;
import models.Estoque;

import java.util.List;
import java.util.Optional;

public class EstoqueRepositorio implements IEstoqueRepositorio {

    private List<Estoque> listaEstoque;

    public EstoqueRepositorio(List<Estoque> listaEstoque) {
        this.listaEstoque = listaEstoque;
    }

    @Override
    public void inserir(Estoque object) {

    }

    @Override
    public List<Estoque> pegarLista() {
        return null;
    }

    @Override
    public Optional<Estoque> recuperarPorId(int id) {
        return Optional.empty();
    }

    @Override
    public void atualizar(Estoque object) {

    }

    @Override
    public void remover(Estoque object) {

    }

    @Override
    public void removerPorId(int id) {

    }
}
