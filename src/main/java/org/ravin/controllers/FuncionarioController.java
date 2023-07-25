package org.ravin.controllers;

import org.ravin.controllers.interfaces.IFuncionarioController;
import org.ravin.dao.interfaces.IFuncionarioRepositorio;
import org.ravin.models.Funcionario;

import org.ravin.utils.exceptions.EntidadeNaoEncontradaException;

import java.util.List;
import java.util.Optional;

public class FuncionarioController implements IFuncionarioController {
    private final IFuncionarioRepositorio funcionarioRepositorio;
    public FuncionarioController(IFuncionarioRepositorio funcionarioRepository) {
        this.funcionarioRepositorio = funcionarioRepository;
    }

    @Override
    public void atualizar(Funcionario objeto) {
        funcionarioRepositorio.atualizar(objeto);
    }
    
    @Override
    public boolean remover(Funcionario objeto) {
        funcionarioRepositorio.remover(objeto);
        return true;
    }
    
    @Override
    public void inserir(Funcionario objeto) {
        funcionarioRepositorio.inserir(objeto);

    }

    @Override
        public Funcionario recuperarPorId(int id) throws EntidadeNaoEncontradaException{
            Optional<Funcionario> funcionario = funcionarioRepositorio.recuperarPorId(id);
            if (funcionario.isPresent()) {
                return funcionario.get();
            } else {
                throw new EntidadeNaoEncontradaException("Funcionário não encontrado para o ID: " + id);
            }
        }

    @Override
    public List<Funcionario> pegarLista() {
             return funcionarioRepositorio.pegarLista();
    }

    @Override
    public Funcionario buscaPorCpf(String cpf) throws EntidadeNaoEncontradaException{
        Optional<Funcionario> funcionario = funcionarioRepositorio.recuperarFuncionarioPorCpf(cpf);
        if (funcionario.isPresent()) {
            return funcionario.get();
        } else {
            throw new EntidadeNaoEncontradaException("Funcionário não encontrado com o CPF: " + cpf);
        }
    }
    
}
