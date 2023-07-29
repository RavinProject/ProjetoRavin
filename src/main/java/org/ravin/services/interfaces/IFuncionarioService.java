package org.ravin.services.interfaces;

import org.ravin.models.Funcionario;

import java.util.Optional;

public interface IFuncionarioService extends IService<Funcionario> {
    Optional<Funcionario> recuperarPorCpf(String cpf);
}
