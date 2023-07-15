package dao.interfaces;

import models.Cliente;

import java.util.Optional;

public interface IClienteRepositorio extends IRepositorio<Cliente> {
    Optional<Cliente> recuperarPorCpf(String cpf);
}
