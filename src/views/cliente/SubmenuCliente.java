package views.cliente;

import controllers.ClienteController;
import controllers.interfaces.IClienteController;
import dao.ListasDados;
import dao.interfaces.IClienteRepositorio;
import models.Cliente;
import utils.DateUtils;

import javax.swing.*;

import static views.View.exibeDialogo;
import static views.cliente.AtualizarClienteView.atualizar;
import static views.cliente.CadastrarClienteView.*;
import static views.cliente.ExcluirClienteView.excluirCliente;
import static views.cliente.RecuperarClienteView.listarClientes;
import static views.cliente.RecuperarClienteView.pesquisarClientePorCpf;

public class SubmenuCliente {
    public static void menu() {
        // Injeção de Dependência
        IClienteRepositorio clienteRepo = ListasDados.getInstance().getClienteRepositorio();
        ClienteController clienteController = new ClienteController(clienteRepo);

        boolean exec = true;
        while (exec) {
            String opcao = JOptionPane.showInputDialog(menuInicial());
            switch (opcao) {
                case "1" -> cadastrar(clienteController);
                case "2" -> atualizar(clienteController);
                case "3" -> listarClientes(clienteController);
                case "4" -> pesquisarClientePorCpf(clienteController);
                case "5" -> excluirCliente(clienteController);
                case "x" -> exec = false;
                default -> exibeDialogo("Opção inválida! Voltando...");
            }
        }
    }

    private static String menuInicial(){
        StringBuilder builder = new StringBuilder();
        builder.append(" ==================== RAVIN ==================== ");
        builder.append("\n");
        builder.append("1 - Cadastrar Cliente \n");
        builder.append("2 - Alterar Cliente \n");
        builder.append("3 - Listar Clientes \n");
        builder.append("4 - Visualizar Cliente \n");
        builder.append("5 - Excluir Cliente \n");
        builder.append("x - voltar \n");
        return builder.toString();
    }

    static void imprimeCliente(Cliente cliente) {
        String clienteDados = "ID: " + cliente.getId() +
                "\nNome: " + cliente.getNome() +
                "\nTelefone: " + cliente.getTelefone() +
                "\nEndereço: " + cliente.getEndereco() +
                "\nCPF: " + cliente.getCpf() +
                "\nNascimento: " + DateUtils.dateToString(cliente.getNascimento()) +
                "\nObservação: " + cliente.getObservacao() +
                "\nAtivo: " + (cliente.getAtivo() ? "Sim" : "Não") +
                "\nAlergia: " + cliente.getAlergias() +
                "\nVIP: " + (cliente.isVip() ? "Sim" : "Não");
        exibeDialogo(clienteDados);
    }
}
