package org.ravin.dao;

import org.ravin.dao.interfaces.IGeradorId;
import org.ravin.dao.interfaces.IRepositorio;
import org.ravin.models.Pessoa;

import java.util.List;
import java.util.Optional;

public class PessoaRepositorio implements IRepositorio<Pessoa>, IGeradorId {
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
        return 0;
    }
}
