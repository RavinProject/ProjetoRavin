package services.interfaces;

import java.util.Optional;

import models.Cliente;

public interface IClienteService extends IService <Cliente>{
    Optional<Cliente> recuperarPorCpf(String cpf);
}
