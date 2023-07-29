package org.ravin.views.funcionario;

import org.ravin.controllers.FuncionarioController;
import org.ravin.dao.ListasDados;
import org.ravin.dao.interfaces.IFuncionarioRepositorioLista;
import org.ravin.models.Funcionario;
import org.ravin.services.FuncionarioService;
import org.ravin.services.interfaces.IFuncionarioService;

import javax.swing.*;

import static org.ravin.views.View.exibeDialogo;
import static org.ravin.views.funcionario.AtualizarFuncionarioView.atualizarFuncionario;
import static org.ravin.views.funcionario.CadastrarFuncionarioView.cadastrarFuncionario;
import static org.ravin.views.funcionario.ExcluirFuncionarioView.excluirFuncionario;
import static org.ravin.views.funcionario.RecuperarFuncionarioView.listarFuncionarios;
import static org.ravin.views.funcionario.RecuperarFuncionarioView.recuperarFuncionarioPorCpf;

public class SubmenuFuncionario {
    public static void menuFuncionario() {

        // Injeção de Dependência
        IFuncionarioRepositorioLista funcionarioRepo = ListasDados.getInstance().getFuncionarioRepositorio();
        IFuncionarioService funcionarioService = new FuncionarioService(funcionarioRepo);
        FuncionarioController funcionarioController = new FuncionarioController(funcionarioService);

        boolean exec = true;
        while (exec) {
            String opcao = JOptionPane.showInputDialog(menuInicial());
            switch (opcao) {
                case "1" -> cadastrarFuncionario(funcionarioController);
                case "2" -> atualizarFuncionario(funcionarioController);
                case "3" -> listarFuncionarios(funcionarioController);
                case "4" -> recuperarFuncionarioPorCpf(funcionarioController);
                case "5" -> excluirFuncionario(funcionarioController);
                case "x" -> exec = false;
                default -> exibeDialogo("Opção inválida! Voltando...");
            }
        }
    }

    private static String menuInicial() {
        return """
                 ==================== RAVIN ====================\s
                1 - Cadastrar Funcionario\s
                2 - Alterar Funcionario\s
                3 - Listar Funcionarios\s
                4 - Visualizar Funcionario\s
                5 - Excluir Funcionario\s
                x - voltar\s
                """;
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