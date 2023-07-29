package org.ravin.views.cliente;

import org.ravin.controllers.interfaces.IClienteController;
import org.ravin.models.Cliente;
import org.ravin.models.Pessoa;
import org.ravin.utils.exceptions.EntidadeNaoEncontradaException;

import static org.ravin.views.View.exibeDialogo;
import static org.ravin.views.View.solicitaEntradaDeDado;
import static org.ravin.views.cliente.SubmenuCliente.imprimeCliente;


public class RecuperarClienteView {
    static void pesquisarClientePorCpf(IClienteController clienteController) {

        String cpf = solicitaEntradaDeDado("Informe o CPF do cliente que deseja visualizar:");
        try{
            Cliente cliente = clienteController.recuperarPorCpf(cpf);
            imprimeCliente(cliente);
        }catch(EntidadeNaoEncontradaException e){
            exibeDialogo(e.getMessage());
        }
    }

    static void listarClientes(IClienteController clienteController) {
        StringBuilder texto = new StringBuilder();
        for (Pessoa cliente : clienteController.recuperarTodos()) {
            if(cliente instanceof Cliente){
                texto.append("ID: ")
                        .append(cliente.getId())
                        .append(" CPF: ")
                        .append(cliente.getCpf())
                        .append(cliente.getAtivo() ? " " : " (INATIVO) ")
                        .append(cliente.getNome())
                        .append("\n");
            }
        }
        exibeDialogo(texto.toString());
    }
}
