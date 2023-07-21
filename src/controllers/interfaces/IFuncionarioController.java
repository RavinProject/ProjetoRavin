package controllers.interfaces;

import models.Funcionario;

public interface IFuncionarioController extends IController<Funcionario> {

    Funcionario buscaPorCpf(String cpf);
}
