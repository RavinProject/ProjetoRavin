package views;

import java.util.Date;
import java.util.InputMismatchException;

import javax.swing.JOptionPane;

import controllers.*;
import models.Cliente;
import models.Pessoa;
import utils.DateUtils;

public class CadastroClienteView extends View {


    public static void menu() {
        boolean exec = true;
        while (exec) {
            String opcao = JOptionPane.showInputDialog(menuInicial());
            switch (opcao) {
                case "1":
                    cadastrar();
                    break;
                case "2":
                    atualizar();
                    break;
                case "3":
                    listarClientes();
                    break;
                case "4":
                    pesquisarClientePorCpf();
                    break;
                case "5":
                    excluirCliente();
                    break;
                case "x":
                    exec = false;
                    break;
                default:
                exibeDialogo("Opção inválida! Voltando...");
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
    
    private static void cadastrar() {
        ClienteController clienteController = new ClienteController();
        Cliente cliente = new Cliente();
        try {
            cliente.setNome(solicitaEntradaDeDado("Informe o nome do cliente:"));
            cliente.setTelefone(solicitaEntradaDeDado("Informe o telefone:"));
            cliente.setEndereco(solicitaEntradaDeDado("Endereço: "));
            cliente.setCpf(solicitaEntradaDeDado("Informe o CPF:"));
            cliente.setNascimento(DateUtils.stringToDate(solicitaEntradaDeDado("Data de nascimento: \nFormato: dd/mm/yyyy")));
            cliente.setObservacao(solicitaEntradaDeDado("Informe uma observação ou tecle enter para continuar:"));
            cliente.setAlergias(solicitaEntradaDeDado("Alergias: "));
            boolean vip = solicitaEntradaDeDado("VIP?\n 0 - Não \n 1 - Sim").equals("1") ? true : false;
            cliente.setVip(vip);
            cliente.setAtivo(true);
            cliente.setCriadoEm(new Date());
            cliente.setCriadoPor(null);
            cliente.setAlteradoEm(new Date());
            cliente.setAlteradoPor(null);
            clienteController.inserir(cliente);
            exibeDialogo("Cliente inserido com sucesso!");
            imprimeCliente(clienteController.buscaPorCpf(cliente.getCpf()));
        } catch(InputMismatchException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            exibeDialogo("Um erro ocorreu!\nCadastro não finalizado...");
            e.printStackTrace();
        }
    }

    private static void atualizar() {
        ClienteController clienteController = new ClienteController();

        try {
            String cpf = solicitaEntradaDeDado("Informe o CPF do cliente que deseja alterar:");
            Cliente cliente = clienteController.buscaPorCpf(cpf);
            
            if (cliente != null) {
                cliente.setNome(solicitaEntradaDeDado("Nome:", cliente.getNome()));
                cliente.setTelefone(solicitaEntradaDeDado("Telefone:", cliente.getTelefone()));
                cliente.setEndereco(solicitaEntradaDeDado("Endereço: ", cliente.getEndereco()));
                cliente.setCpf(solicitaEntradaDeDado("CPF:", cliente.getCpf()));
                cliente.setNascimento(DateUtils.stringToDate(solicitaEntradaDeDado("Data de nascimento: \nFormato: dd/mm/yyyy", DateUtils.dateToString(cliente.getNascimento()))));
                cliente.setObservacao(solicitaEntradaDeDado("Observação", cliente.getObservacao()));
                cliente.setAlergias(solicitaEntradaDeDado("Alergias: ", cliente.getAlergias()));
                boolean vip = solicitaEntradaDeDado("VIP?\n 0 - Não \n 1 - Sim", cliente.isVip() ? "1" : "0").equals("1") ? true : false;
                cliente.setVip(vip);
                boolean ativo = solicitaEntradaDeDado("Ativo?\n 0 - Não \n 1 - Sim", cliente.getAtivo() ? "1" : "0").equals("1") ? true : false;
                cliente.setAtivo(ativo);
                cliente.setAlteradoEm(new Date());
                cliente.setAlteradoPor(null);
                clienteController.atualizar(cliente);
                exibeDialogo("Cliente atualizado com sucesso!");
                imprimeCliente(clienteController.buscaPorCpf(cliente.getCpf()));
            } else {
                exibeDialogo("Cliente não encontrado!");
            }
        } catch (Exception e) {
            exibeDialogo("Dado informado inválido!\nCadastro não finalizado...");
            e.printStackTrace();
        }
    }

    private static void pesquisarClientePorCpf() {
        ClienteController clienteController = new ClienteController();

        String cpf = solicitaEntradaDeDado("Informe o CPF do cliente que deseja alterar:");
        Cliente cliente = clienteController.buscaPorCpf(cpf);
        
        if (cliente != null) {
            imprimeCliente(cliente);
        } else {
            exibeDialogo("Cliente não encontrado com o cpf informado!");
        }
    }

    private static void imprimeCliente(Cliente cliente) {
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

    private static void listarClientes() {
        ClienteController clienteController = new ClienteController();
        String texto = "";
        for (Pessoa cliente : clienteController.pegarLista()) {
            if(cliente instanceof Cliente){
                texto += "ID: " + cliente.getId() + " CPF: " + cliente.getCpf() + (cliente.getAtivo() ? " " : " (INATIVO) ") + cliente.getNome() + "\n";
            }
        }
        exibeDialogo(texto);
    }

    private static void excluirCliente() {
        ClienteController clienteController = new ClienteController();
        try {
            String cpf = solicitaEntradaDeDado("Informe o CPF do cliente que deseja alterar:");
            Cliente cliente = clienteController.buscaPorCpf(cpf);
           
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
