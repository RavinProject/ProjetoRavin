package org.ravin.views.cliente;

import org.ravin.controllers.ClienteController;
import org.ravin.controllers.interfaces.IClienteController;
import org.ravin.models.Cliente;
import org.ravin.services.ClienteService;
import org.ravin.services.interfaces.IClienteService;
import org.ravin.utils.DateUtils;
import org.ravin.views.View;

import static org.ravin.views.cliente.AtualizarClienteView.atualizar;
import static org.ravin.views.cliente.CadastrarClienteView.cadastrar;
import static org.ravin.views.cliente.ExcluirClienteView.excluirCliente;
import static org.ravin.views.cliente.RecuperarClienteView.listarClientes;
import static org.ravin.views.cliente.RecuperarClienteView.pesquisarClientePorCpf;

public class SubmenuCliente extends View{
    public static void menuCliente() {
        // Injeção de Dependência
        IClienteService clienteServico = new ClienteService();
        IClienteController clienteController = new ClienteController(clienteServico);

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
