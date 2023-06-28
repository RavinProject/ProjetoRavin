package controllers;

import java.util.Iterator;
import java.util.List;



import dao.ListasDados;
import models.Pessoa;

public class PessoaController extends Controller<Pessoa> {

    public PessoaController() {
    }

    public List<Pessoa> pegaLista() {
        return ListasDados.getInstance().getListaPessoas();
    }

    @Override
    public void atualizar(Pessoa pessoa) {
        for (int i = 0; i < pegaLista().size(); i++) {
            if (pegaLista().get(i).getId() == pessoa.getId()) {
                pegaLista().set(i, pessoa);
                break;
            }
        }
    }

    @Override
    public boolean remover(Pessoa pessoa) {
        return pegaLista().removeIf(p -> p.getId() == pessoa.getId());
    }

    @Override
    public void inserir(Pessoa pessoa) {
        if (pessoa.getId() == 0) {
            pessoa.setId(geraProximoId());
        }
        pegaLista().add(pessoa);
    }

    public int geraProximoId() {
        return pegaLista().size() + 1;
    }

    @Override
    public Pessoa recuperar(int id) {
        for (Pessoa pessoa : pegaLista()) {
            if (pessoa.getId() == id) {
                return pessoa;
            }
        }
        return null;
    }

    @Override
    public List<Pessoa> pegarLista() {
        return pegaLista();
    }

    public Pessoa buscaPorCpf(String cpf) {
        for (Pessoa pessoa : pegaLista()) {
            if (pessoa.getCpf().equals(cpf) && pessoa instanceof Pessoa) {
                return pessoa;
            }
        }
        return null;
    }

}
