package org.ravin.dao.interfaces;

import org.ravin.models.Funcionario;
import org.ravin.utils.interfaces.IGeradorId;

import java.util.Optional;

public interface IFuncionarioRepositorioLista extends IRepositorioLista<Funcionario>, IGeradorId<Funcionario> {

    Optional<Funcionario> recuperarPorCpf(String cpf);

    default int getId(Funcionario funcionario){
        return funcionario.getId();
    }
}
