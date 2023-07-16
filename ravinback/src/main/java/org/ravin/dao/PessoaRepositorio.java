package org.backend.dao;

import dao.interfaces.IRepositorio;
import models.Pessoa;

import java.util.List;
import java.util.Optional;

public class PessoaRepositorio implements IRepositorio<Pessoa> {
    @Override
    public void inserir(Pessoa object) {

    }

    @Override
    public List<Pessoa> pegarLista() {
        return null;
    }

    @Override
    public Optional<Pessoa> recuperarPorId(int id) {
        return Optional.empty();
    }

    @Override
    public void atualizar(Pessoa object) {

    }

    @Override
    public void remover(Pessoa object) {

    }

    @Override
    public void removerPorId(int id) {

    }

    @Override
    public int geraProximoId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'geraProximoId'");
    }
}
