package views.funcionario;

import controllers.interfaces.IFuncionarioController;
import models.Funcionario;
import models.Pessoa;

import static views.View.exibeDialogo;
import static views.View.solicitaEntradaDeDado;
import static views.funcionario.SubmenuFuncionarioView.imprimeFuncionario;

public class RecuperarFuncionarioView {
    static void pesquisarClientePorCpf(IFuncionarioController funcionarioController) {

        String cpf = solicitaEntradaDeDado("Informe o CPF do funcioanrio que deseja alterar:");
        Funcionario funcionario = funcionarioController.buscaPorCpf(cpf);

        if (funcionario != null) {
            imprimeFuncionario(funcionario);
        } else {
            exibeDialogo("funcionario não encontrado com o cpf informado!");
        }
    }



    static void listarfuncionarios(IFuncionarioController funcionarioController) {
        StringBuilder texto = new StringBuilder();
        for (Pessoa funcionario : funcionarioController.pegarLista()) {
            if(funcionario instanceof Funcionario){
                texto.append("ID: ")
                        .append(funcionario.getId())
                        .append(" CPF: ")
                        .append(funcionario.getCpf())
                        .append(funcionario.getAtivo() ? " " : " (INATIVO) ")
                        .append(funcionario.getNome())
                        .append("\n");
            }
        }
        exibeDialogo(texto.toString());
    }
}
