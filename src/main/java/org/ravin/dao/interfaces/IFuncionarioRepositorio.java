package org.ravin.dao.interfaces;

import org.ravin.models.Funcionario;

import java.util.Optional;

public interface IFuncionarioRepositorio extends IRepositorio<Funcionario>, IGeradorId {
    Optional<Funcionario> recuperarFuncionarioPorCpf(String cpf);
}
