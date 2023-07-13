package dao;

import dao.interfaces.IFuncionarioRepositorio;
import models.Funcionario;

import java.util.List;
import java.util.Optional;

public class FuncionarioRepositorio implements IFuncionarioRepositorio {
    private List<Funcionario> listaFuncionarios;

    public FuncionarioRepositorio(List<Funcionario> listaFuncionarios) {
        this.listaFuncionarios = listaFuncionarios;
    }

    @Override
    public void inserir(Funcionario object) {

    }

    @Override
    public List<Funcionario> pegarLista() {
        return null;
    }

    @Override
    public Optional<Funcionario> recuperarPorId(int id) {
        return Optional.empty();
    }

    @Override
    public void atualizar(Funcionario object) {

    }

    @Override
    public void remover(Funcionario object) {

    }

    @Override
    public void removerPorId(int id) {

    }
}
