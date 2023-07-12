package dao;

import dao.interfaces.IFuncionarioRepositorio;
import models.Funcionario;

import java.util.List;

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
        pegarLista().add(funcionario);
    }

    public int geraProximoId() {
        int maiorId = 0;
        for (Funcionario funcionario : pegarLista()) {
            if (funcionario.getId() > maiorId) {
                maiorId = funcionario.getId();
            }
        }
        return maiorId + 1;
    }

    @Override
    public List<Funcionario> pegarLista() {
        return listaFuncionarios;
    }

    @Override
    public Funcionario recuperarPorId(int id) {
        for (Funcionario funcionario : pegarLista()) {
            if (funcionario.getId() == id) {
                return funcionario;
            }
        }
        return null;
    }

    @Override
    public void atualizar(Funcionario funcionario) {
        for (int i = 0; i < pegarLista().size(); i++) {
            if (pegarLista().get(i).getId() == funcionario.getId()) {
                pegarLista().set(i, funcionario);
                break;
            }
        }
    }

    @Override
    public void remover(Funcionario funcionario) {
        pegarLista().removeIf(p -> p.getId() == funcionario.getId());
    }

    @Override
    public void removerPorId(int id) {
        pegarLista().removeIf(p -> p.getId() == id);
    }
}
