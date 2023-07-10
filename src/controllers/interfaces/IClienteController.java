package controllers.interfaces;

import models.Cliente;

public interface IClienteController extends IController<Cliente> {
    Cliente recuperarPorCpf(String cpf);
}