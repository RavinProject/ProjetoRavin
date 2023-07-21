package org.ravin.controllers.interfaces;

import org.ravin.models.Funcionario;
import org.ravin.utils.exceptions.EntidadeNaoEncontradaException;

public interface IFuncionarioController extends IController<Funcionario> {
    Funcionario buscaPorCpf(String cpf) throws EntidadeNaoEncontradaException;
}
