package controllers.interfaces;

import models.Pessoa;

public interface IPessoaController extends IController<Pessoa> {
    Pessoa buscaPorCpf(String cpf);
}