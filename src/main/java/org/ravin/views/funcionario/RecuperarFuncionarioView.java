package org.ravin.views.funcionario;

import org.ravin.controllers.interfaces.IFuncionarioController;
import org.ravin.models.Funcionario;
import org.ravin.models.Pessoa;
import org.ravin.utils.exceptions.EntidadeNaoEncontradaException;

import static org.ravin.views.View.exibeDialogo;
import static org.ravin.views.View.solicitaEntradaDeDado;
import static org.ravin.views.funcionario.SubmenuFuncionario.imprimeFuncionario;


public class RecuperarFuncionarioView {
    static void pesquisarFuncionarioPorCpf(IFuncionarioController funcionarioController) {

        String cpf = solicitaEntradaDeDado("Informe o CPF do funcionário que deseja visualizar:");
        try{
            Funcionario funcionario = funcionarioController.buscaPorCpf(cpf);
            imprimeFuncionario(funcionario);
        }catch(EntidadeNaoEncontradaException e){
            exibeDialogo(e.getMessage());
        }
    }


    static void listarFuncionarios(IFuncionarioController funcionarioController) {
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
