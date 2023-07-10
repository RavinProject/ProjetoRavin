package views.cliente;

import controllers.interfaces.IClienteController;
import models.Cliente;

import javax.swing.*;

import static views.View.*;
import static views.View.exibeDialogo;

public class ExcluirClienteView {
    static void excluirCliente(IClienteController clienteController) {
        try {
            String cpf = solicitaEntradaDeDado("Informe o CPF do cliente que deseja alterar:");
            Cliente cliente = clienteController.recuperarPorCpf(cpf);

            if (cliente != null) {
                String clienteDados = "O seguinte cliente será excluído:" +
                        "\n\nID: " + cliente.getId() +
                        "\nNome: " + cliente.getNome() +
                        "\nTelefone: " + cliente.getTelefone() +
                        "\nEndereço: " + cliente.getEndereco() +
                        "\nCPF: " + cliente.getCpf() +
                        "\n\nClique em OK para confirmar ou Cancele.";
                if(confirmaAcao(clienteDados) == JOptionPane.YES_OPTION){
                    boolean excluido = clienteController.remover(cliente);
                    exibeDialogo(excluido ? "O cliente foi removido!" : "Não foi possível excluir o cliente da lista");
                }else{
                    exibeDialogo("Nada foi alterado!");
                }
            } else {
                exibeDialogo("Cliente não encontrado com o cpf informado!");
            }
        } catch (Exception e) {
            exibeDialogo("Dado informado inválido!\nCadastro não finalizado...");
            e.printStackTrace();
        }
    }
}
