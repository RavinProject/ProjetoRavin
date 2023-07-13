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
    public void inserir(Funcionario funcionario) {
        if (funcionario.getId() == 0) {
            funcionario.setId(geraProximoId());
        }
        pegarLista().add(funcionario); // Adiciona o funcionario na lista
    }

    @Override
    public List<Funcionario> pegarLista() {
        return listaFuncionarios;
    }

    @Override
    public Optional<Funcionario> recuperarPorId(int id) {
        // Itera pela lista e tenta encontrar um funcionario com o ID fornecido
        for (Funcionario funcionario : pegarLista()) {
            if (funcionario.getId() == id) {
                return Optional.of(funcionario);
            }
        }
        return Optional.empty(); // Retorna um Optional vazio se não encontrar
    }

    @Override
    public void atualizar(Funcionario funcionarioAtualizado) {
        // Itera pela lista e atualiza o cliente com o mesmo ID
        for (int i = 0; i < pegarLista().size(); i++) {
            if (pegarLista().get(i).getId() == funcionarioAtualizado.getId()) {
                pegarLista().set(i, funcionarioAtualizado);
                break;
            }
        }
    }

    @Override
    public void remover(Funcionario funcionario) {
        pegarLista().remove(funcionario); // Remove o cliente da lista
    }

    @Override
    public void removerPorId(int id) {
        // Itera pela lista e remove o funcionario com o ID fornecido
        pegarLista().removeIf(funcionario -> funcionario.getId() == id);
    }

    @Override
    public int geraProximoId() {
        int maiorId = 0;
        for (Funcionario funcionario : pegarLista()) {
            if (funcionario.getId() > maiorId) {
                maiorId = funcionario.getId();
            }
        }
        return maiorId + 1;
    }
}
