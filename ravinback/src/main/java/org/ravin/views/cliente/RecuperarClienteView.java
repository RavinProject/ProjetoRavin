package views.cliente;

import controllers.interfaces.IClienteController;
import models.Cliente;
import models.Pessoa;

import static views.View.exibeDialogo;
import static views.View.solicitaEntradaDeDado;
import static views.cliente.SubmenuCliente.imprimeCliente;

public class RecuperarClienteView {
    static void pesquisarClientePorCpf(IClienteController clienteController) {

        String cpf = solicitaEntradaDeDado("Informe o CPF do cliente que deseja alterar:");
        Cliente cliente = clienteController.recuperarPorCpf(cpf);

        if (cliente != null) {
            imprimeCliente(cliente);
        } else {
            exibeDialogo("Cliente não encontrado com o cpf informado!");
        }
    }



    static void listarClientes(IClienteController clienteController) {
        StringBuilder texto = new StringBuilder();
        for (Pessoa cliente : clienteController.pegarLista()) {
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
