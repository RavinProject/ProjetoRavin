package dao;

import dao.interfaces.IRepositorio;
import models.Pessoa;

import java.util.List;

public class PessoaRepositorio implements IRepositorio<Pessoa> {
    @Override
    public void inserir(Pessoa object) {

    }

    @Override
    public List<Pessoa> pegarLista() {
        return null;
    }

    @Override
    public Pessoa recuperarPorId(int id) {
        return null;
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
}
