package org.backend.controllers;

import org.backend.controllers.interfaces.IFuncionarioController;
import models.Funcionario;
import models.Pessoa;

import java.util.List;

public class FuncionarioController implements IFuncionarioController {

    public FuncionarioController() {

    }
    @Override
    public Funcionario buscaPorCpf(String cpf) {
        for (Pessoa pessoa : pegarLista()) {
            if (pessoa.getCpf().equals(cpf) && pessoa instanceof Funcionario) {
                return (Funcionario) pessoa;
            }
        }
        return null;
    }

    @Override
    public void inserir(Funcionario objeto) {

    }

    @Override
    public Funcionario recuperarPorId(int id) {
        return null;
    }

    @Override
    public List<Funcionario> pegarLista() {
        return null;
    }

    @Override
    public void atualizar(Funcionario objeto) {

    }

    @Override
    public boolean remover(Funcionario objeto) {
        return false;
    }

}
