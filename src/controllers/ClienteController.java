package controllers;

import models.Cliente;
import models.Pessoa;

public class ClienteController extends PessoaController{

    public ClienteController() {
        
    }

    public Cliente buscaPorCpf(String cpf) {
        for (Pessoa pessoa : pegarLista()) {
            if (pessoa.getCpf().equals(cpf) && pessoa instanceof Cliente) {
                return (Cliente) pessoa;
            }
        }
        return null;
    }
}
