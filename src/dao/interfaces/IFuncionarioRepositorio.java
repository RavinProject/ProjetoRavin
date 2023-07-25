package dao.interfaces;

import models.Funcionario;

import java.util.Optional;

public interface IFuncionarioRepositorio extends IRepositorio<Funcionario> {

    Optional<Funcionario> buscarPorCpf(String cpf);
}
