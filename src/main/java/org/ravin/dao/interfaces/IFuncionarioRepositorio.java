package org.ravin.dao.interfaces;

import org.ravin.models.Funcionario;
import org.ravin.utils.interfaces.IGeradorId;

import java.util.Optional;

public interface IFuncionarioRepositorio extends IRepositorio<Funcionario>, IGeradorId<Funcionario> {
    default int getId(Funcionario funcionario){
        return funcionario.getId();
    }
    Optional<Funcionario> recuperarFuncionarioPorCpf(String cpf);
}
