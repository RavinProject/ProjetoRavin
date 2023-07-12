package dao.interfaces;

import models.Cliente;

public interface IClienteRepositorio extends IRepositorio<Cliente> {

    Cliente recuperarPorCpf(String cpf);
}
