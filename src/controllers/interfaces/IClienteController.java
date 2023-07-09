package controllers.interfaces;

import models.Cliente;

public interface IClienteController extends IController<Cliente> {
    Cliente buscaPorCpf(String cpf);
}