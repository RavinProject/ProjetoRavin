package views.cliente;

import controllers.ClienteController;
import dao.ListasDados;
import dao.interfaces.IClienteRepositorio;
import models.Cliente;
import utils.DateUtils;

import static views.cliente.AtualizarClienteView.atualizar;
import static views.cliente.CadastrarClienteView.*;
import static views.cliente.ExcluirClienteView.excluirCliente;
import static views.cliente.RecuperarClienteView.listarClientes;
import static views.cliente.RecuperarClienteView.pesquisarClientePorCpf;

import views.View;

public class SubmenuCliente extends View{
    public static void menu() {
        // Injeção de Dependência
        IClienteRepositorio clienteRepo = ListasDados.getInstance().getClienteRepositorio();
        ClienteController clienteController = new ClienteController(clienteRepo);

        boolean exec = true;
        while (exec) {
            String opcao = solicitaEntradaDeDado(menuInicial());
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
        builder.append("""
                ==================== RAVIN ====================
                CLIENTE:
                1 - Cadastrar Cliente
                2 - Alterar Cliente
                3 - Listar Clientes
                4 - Visualizar Cliente
                5 - Excluir Cliente
                x - voltar
                """);
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
