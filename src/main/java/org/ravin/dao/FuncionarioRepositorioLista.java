package org.ravin.dao;

import org.ravin.dao.interfaces.IFuncionarioRepositorioLista;
import org.ravin.models.Funcionario;

import java.util.List;
import java.util.Optional;

public class FuncionarioRepositorioLista implements IFuncionarioRepositorioLista {

    private final List<Funcionario> listaFuncionarios;

    public FuncionarioRepositorioLista(List<Funcionario> listaFuncionarios) {
        this.listaFuncionarios = listaFuncionarios;
    }

    //1
    @Override
    public void inserir(Funcionario funcionario) {
        if (funcionario.getId() == 0) {
            funcionario.setId(geraProximoId(listaFuncionarios));
        }
        recuperarTodos().add(funcionario); // Adiciona o funcionario na lista
    }

    @Override
    public List<Funcionario> recuperarTodos() {
        return listaFuncionarios; // Retornar a lista de funcionario
    }   

    @Override
    public Optional<Funcionario> recuperarPorId(int id) {
        // Itera pela lista e tenta encontrar um funcionario com o ID fornecido
        for (Funcionario funcionario : recuperarTodos()) {
            if (funcionario.getId() == id) {
                return Optional.of(funcionario);
            }
        }
        return Optional.empty(); // Retorna um Optional vazio se não encontrar
    }

    @Override
    public void atualizar(Funcionario funcionarioAtualizado) {
        // Itera pela lista e atualiza o cliente com o mesmo ID
        for (int i = 0; i < recuperarTodos().size(); i++) {
            if (recuperarTodos().get(i).getId() == funcionarioAtualizado.getId()) {
                recuperarTodos().set(i, funcionarioAtualizado);
                break;
            }
        }
    }


    @Override
    public void remover(Funcionario funcionario) {
        recuperarTodos().remove(funcionario); // Remove o cliente da lista
    }

    @Override
    public void removerPorId(int id) {
        // Itera pela lista e remove o funcionario com o ID fornecido
        recuperarTodos().removeIf(funcionario -> funcionario.getId() == id);
    }

    @Override
    public Optional<Funcionario> recuperarPorCpf(String cpf) {
        // Itera pela lista e tenta encontrar um cliente com o CPF fornecido
        for (Funcionario funcionario : recuperarTodos()) {
            if (funcionario.getCpf().equals(cpf)) {
                return Optional.of(funcionario);
            }
        }
        return Optional.empty(); // Retorna um Optional vazio se não encontrar
    }

}
