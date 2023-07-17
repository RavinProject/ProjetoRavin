package org.ravin.controllers.interfaces;

import org.ravin.models.Funcionario;

public interface IFuncionarioController extends IController<Funcionario> {
    Funcionario buscaPorCpf(String cpf);
}
