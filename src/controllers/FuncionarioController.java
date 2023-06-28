package controllers;

import models.Funcionario;
import models.Pessoa;

public class FuncionarioController extends PessoaController {

    public FuncionarioController() {

    }

    public Funcionario buscaPorCpf(String cpf) {
        for (Pessoa pessoa : pegaLista()) {
            if (pessoa.getCpf().equals(cpf) && pessoa instanceof Funcionario) {
                return (Funcionario) pessoa;
            }
        }
        return null;
    }
}
