package org.ravin.services;

import org.ravin.dao.interfaces.IFuncionarioRepositorioLista;
import org.ravin.models.Funcionario;
import org.ravin.services.interfaces.IFuncionarioService;

import java.util.List;
import java.util.Optional;

public class FuncionarioService implements IFuncionarioService {
    private final IFuncionarioRepositorioLista funcionarioRepositorio;
    public FuncionarioService(IFuncionarioRepositorioLista funcionarioRepo){
        funcionarioRepositorio = funcionarioRepo;
    }

    @Override
    public void inserir(Funcionario funcionario) { funcionarioRepositorio.inserir(funcionario);
    }

    @Override
    public Optional<Funcionario> recuperarPorId(int id) {
        return funcionarioRepositorio.recuperarPorId(id);
    }

    @Override
    public List<Funcionario> recuperarTodos() {
        return funcionarioRepositorio.pegarLista();
    }


    @Override
    public void atualizar(Funcionario funcionario) { funcionarioRepositorio.atualizar(funcionario);
    }

    @Override
    public boolean remover(Funcionario funcionario) {
        try{ funcionarioRepositorio.remover(funcionario);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Optional<Funcionario> recuperarPorCpf(String cpf) {

        return funcionarioRepositorio.recuperarPorCpf(cpf);
    }
}
