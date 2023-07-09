package controllers.interfaces;

import models.Cliente;
import models.Pessoa;

public interface IClienteController extends IController<Cliente> {
    Cliente buscaPorCpf(String cpf);
}