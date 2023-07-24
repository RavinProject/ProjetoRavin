package org.ravin.controllers;

import org.ravin.controllers.interfaces.IFuncionarioController;
import org.ravin.dao.interfaces.IFuncionarioRepositorio;
import org.ravin.models.Funcionario;
import org.ravin.models.Pessoa;

import java.util.List;
import java.util.NoSuchElementException;
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
        public Funcionario recuperarPorId(int id) {
            Optional<Funcionario> funcionario = funcionarioRepositorio.recuperarPorId(id);
            if (funcionario.isPresent()) {
                return funcionario.get();
            } else {
                throw new NoSuchElementException("Funcionario não encontrado para o ID: " + id);
            }
        }

    @Override
    public List<Funcionario> pegarLista() {
             return funcionarioRepositorio.pegarLista();
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
    
}
