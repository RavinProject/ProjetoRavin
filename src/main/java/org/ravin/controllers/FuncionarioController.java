package org.ravin.controllers;

import org.ravin.controllers.interfaces.IFuncionarioController;
import org.ravin.models.Funcionario;
import org.ravin.services.interfaces.IFuncionarioService;
import org.ravin.utils.exceptions.EntidadeNaoEncontradaException;

import java.util.List;
import java.util.Optional;

public class FuncionarioController implements IFuncionarioController {
    private final IFuncionarioService funcionarioService;
    public FuncionarioController(IFuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @Override
    public void inserir(Funcionario objeto) {
        funcionarioService.inserir(objeto);

    }

    @Override
    public void atualizar(Funcionario objeto) {
        funcionarioService.atualizar(objeto);
    }

    @Override
        public Funcionario recuperarPorId(int id) throws EntidadeNaoEncontradaException{
            Optional<Funcionario> funcionario = funcionarioService.recuperarPorId(id);
            if (funcionario.isPresent()) {
                return funcionario.get();
            } else {
                throw new EntidadeNaoEncontradaException("Funcionário não encontrado para o ID: " + id);
            }
        }

    @Override
    public List<Funcionario> recuperarTodos() {
             return funcionarioService.recuperarTodos();
    }

    @Override
    public Funcionario buscaPorCpf(String cpf) throws EntidadeNaoEncontradaException{
        Optional<Funcionario> funcionario = funcionarioService.recuperarPorCpf(cpf);
        if (funcionario.isPresent()) {
            return funcionario.get();
        } else {
            throw new EntidadeNaoEncontradaException("Funcionário não encontrado com o CPF: " + cpf);
        }
    }


    @Override
    public boolean remover(Funcionario objeto) {
        funcionarioService.remover(objeto);
        return true;
    }
}
