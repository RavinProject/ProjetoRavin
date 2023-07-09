package controllers;

import java.util.List;


import controllers.interfaces.IController;
import controllers.interfaces.IPessoaController;
import dao.ListasDados;
import models.Pessoa;

public class PessoaController implements IPessoaController {

    public PessoaController() {
    }

    @Override
    public void atualizar(Pessoa pessoa) {
        for (int i = 0; i < pegarLista().size(); i++) {
            if (pegarLista().get(i).getId() == pessoa.getId()) {
                pegarLista().set(i, pessoa);
                break;
            }
        }
    }

    @Override
    public boolean remover(Pessoa pessoa) {
        return pegarLista().removeIf(p -> p.getId() == pessoa.getId());
    }

    @Override
    public void inserir(Pessoa pessoa) {
        if (pessoa.getId() == 0) {
            pessoa.setId(geraProximoId());
        }
        pegarLista().add(pessoa);
    }

    public int geraProximoId() {
        return pegarLista().size() + 1;
    }

    @Override
    public Pessoa recuperarPorId(int id) {
        for (Pessoa pessoa : pegarLista()) {
            if (pessoa.getId() == id) {
                return pessoa;
            }
        }
        return null;
    }

    @Override
    public List<Pessoa> pegarLista() {
        return ListasDados.getInstance().getListaPessoas();
    }


    public Pessoa buscaPorCpf(String cpf) {
        for (Pessoa pessoa : pegarLista()) {
            if (pessoa.getCpf().equals(cpf)) {
                return pessoa;
            }
        }
        return null;
    }

}
