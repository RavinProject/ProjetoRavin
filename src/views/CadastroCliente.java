package views;

import java.util.Date;
import java.util.InputMismatchException;

import javax.swing.JOptionPane;

import controllers.*;
import models.Cliente;
import models.Pessoa;
import utils.DateUtils;
import views.menus.ClienteMenu;

public class CadastroCliente extends View {


    public static void menu() {
        boolean exec = true;
        while (exec) {
            String opcao = JOptionPane.showInputDialog(ClienteMenu.inicial());
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
                case "x":
                    exec = false;
                    break;
                default:
                exibeDialogo("Opção inválida! Voltando...");
            }
        }
    }

    private static void cadastrar() {
        ClienteController clienteControler = new ClienteController();
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
            clienteControler.inserir(cliente);
            exibeDialogo("Cliente inserido com sucesso!");
            imprimeCliente(clienteControler.buscaPorCpf(cliente.getCpf()));
        } catch(InputMismatchException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            exibeDialogo("Um erro ocorreu!\nCadastro não finalizado...");
            e.printStackTrace();
        }
    }

    private static void atualizar() {
        ClienteController clienteControler = new ClienteController();

        try {
            String cpf = solicitaEntradaDeDado("Informe o CPF do cliente que deseja alterar:");
            Cliente cliente = clienteControler.buscaPorCpf(cpf);
            
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
                clienteControler.atualizar(cliente);
                exibeDialogo("Cliente atualizado com sucesso!");
                imprimeCliente(clienteControler.buscaPorCpf(cliente.getCpf()));
            } else {
                exibeDialogo("Cliente não encontrado!");
            }
        } catch (Exception e) {
            exibeDialogo("Dado informado inválido!\nCadastro não finalizado...");
            e.printStackTrace();
        }
    }

    private static void pesquisarClientePorCpf() {
        ClienteController clienteControler = new ClienteController();

        try {
            String cpf = solicitaEntradaDeDado("Informe o CPF do cliente que deseja alterar:");
            Cliente cliente = clienteControler.buscaPorCpf(cpf);
           
            if (cliente != null) {
                imprimeCliente(cliente);
            } else {
                exibeDialogo("Cliente não encontrado com o cpf informado!");
            }

        } catch (Exception e) {
            exibeDialogo("Dado informado inválido!\nCadastro não finalizado...");
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
        ClienteController clienteControler = new ClienteController();
        String texto = "";
        for (Pessoa cliente : clienteControler.pegarLista()) {
            if(cliente instanceof Cliente){
                texto += "ID: " + cliente.getId() + " CPF: " + cliente.getCpf() + (cliente.getAtivo() ? " " : " (INATIVO) ") + cliente.getNome() + "\n";
            }
        }
        exibeDialogo(texto);
    }
}
