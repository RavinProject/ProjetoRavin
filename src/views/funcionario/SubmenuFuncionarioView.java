package views.funcionario;

import controllers.FuncionarioController;
import dao.ListasDados;
import dao.interfaces.IFuncionarioRepositorio;
import models.Funcionario;


import javax.swing.*;

import static views.View.exibeDialogo;
import static views.funcionario.AtualizarFuncionarioView.*;
import static views.funcionario.CadastrarFuncionarioView.*;
import static views.funcionario.ExcluirFuncionarioView.excluirFuncionario;
import static views.funcionario.RecuperarFuncionarioView.listarFuncionarios;
import static views.funcionario.RecuperarFuncionarioView.pesquisarFuncionarioPorCpf;

public class SubmenuFuncionarioView {
    public static void menu() {

        // Injeção de Dependência
        IFuncionarioRepositorio funcionarioRepo = ListasDados.getInstance().getFuncionarioRepositorio();
        FuncionarioController funcionarioController = new FuncionarioController(funcionarioRepo);

        boolean exec = true;
        while (exec) {
            String opcao = JOptionPane.showInputDialog(menuInicial());
            switch (opcao) {
                case "1" -> cadastrarFuncionario(funcionarioController);
                case "2" -> atualizar(funcionarioController);
                case "3" -> listarFuncionarios(funcionarioController);
                case "4" -> pesquisarFuncionarioPorCpf(funcionarioController);
                case "5" -> excluirFuncionario(funcionarioController);
                case "x" -> exec = false;
                default -> exibeDialogo("Opção inválida! Voltando...");
            }
        }
    }

    private static String menuInicial(){
        StringBuilder builder = new StringBuilder();
        builder.append(" ==================== RAVIN ==================== ");
        builder.append("\n");
        builder.append("1 - Cadastrar Funcionario \n");
        builder.append("2 - Alterar Funcionario \n");
        builder.append("3 - Listar Funcionarios \n");
        builder.append("4 - Visualizar Funcionario \n");
        builder.append("5 - Excluir Funcionario \n");
        builder.append("x - voltar \n");
        return builder.toString();
    }

    static void imprimeFuncionario(Funcionario funcionario) {
        String funcionarioDados = 
                "ID: " + funcionario.getId() +
                "\n Nome: " + funcionario.getNome() +
                "\n CPF: " + funcionario.getCpf() +
                "\n Data Nascimento: " + funcionario.getNascimento() +
                "\n Telefone: " + funcionario.getTelefone() +
                "\n Endereco: " + funcionario.getEndereco() +
                "\n Estado Civil: " + funcionario.getEstadoCivilString() +
                "\n Escolaridade: " + funcionario.getEscolaridadeString() +
                "\n Cargo: " + funcionario.getCargoString() +
                "\n Disponibilidade: " + funcionario.getDisponibilidadeString() +
                "\n Data de Admissão: " + funcionario.getDataAdmissao() +
                "\n Data de Demissão: " + funcionario.getDataDemissao();   

                exibeDialogo(funcionarioDados);

    
            }
}