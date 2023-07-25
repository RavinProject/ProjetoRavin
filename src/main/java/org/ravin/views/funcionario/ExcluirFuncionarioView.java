package org.ravin.views.funcionario;

import org.ravin.controllers.interfaces.IFuncionarioController;
import org.ravin.models.Funcionario;

import javax.swing.*;

import static org.ravin.views.View.*;

public class ExcluirFuncionarioView {
     static void excluirFuncionario(IFuncionarioController funcionarioController) {
        try {
            String cpf = solicitaEntradaDeDado("Informe o CPF do cliente que deseja alterar:");
            if (cpf == null) return;
            Funcionario funcionario = funcionarioController.buscaPorCpf(cpf);

            if (funcionario != null) {
                String funcionarioDados = "O seguinte funcionario será excluído:" +
                        "\n\nID: " + funcionario.getId() +
                        "\nNome: " + funcionario.getNome() +
                        "\nTelefone: " + funcionario.getTelefone() +
                        "\nEndereço: " + funcionario.getEndereco() +
                        "\nCPF: " + funcionario.getCpf() +
                        "\n\nClique em OK para confirmar ou Cancele.";
                if(confirmaAcao(funcionarioDados) == JOptionPane.YES_OPTION){
                    boolean excluido = funcionarioController.remover(funcionario);
                    exibeDialogo(excluido ? "O funcionario foi removido!" : "Não foi possível excluir o funcionario da lista");
                }else{
                    exibeDialogo("Nada foi alterado!");
                }
            } else {
                exibeDialogo("Funcionario não encontrado com o cpf informado!");
            }
        } catch (Exception e) {
            exibeDialogo("Dado informado inválido!\nCadastro não finalizado...");
            e.printStackTrace();
        }
    }
}
