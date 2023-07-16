package org.ravin.services;

import org.ravin.dao.ListasDados;
import org.ravin.dao.interfaces.IClienteRepositorio;
import org.ravin.dao.interfaces.IEstoqueRepositorio;
import org.ravin.dao.interfaces.IProdutoRepositorio;
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
    public void inserir(Estoque objeto) {

    }

    @Override
    public Optional<Estoque> recuperarPorId(int id) {
        return Optional.empty();
    }

    @Override
    public List<Estoque> pegarLista() {
        return null;
    }

    @Override
    public void atualizar(Estoque objeto) {

    }

    @Override
    public boolean remover(Estoque objeto) {
        return false;
    }

    @Override
    public Optional<Estoque> recuperarPorCodigo(String codigo) {
        return Optional.empty();
    }
}
