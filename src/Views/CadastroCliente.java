package Views;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import Controllers.ClienteController;
import Models.Cliente;

public class CadastroCliente extends View {

    private static Scanner scanner;

    public static void menu() {
        boolean exec = true;
        while (exec) {
            System.out.println(VERDE + "Selecione a opção desejada:\n" +
                    "1 - Cadastrar Cliente\n" +
                    "2 - Alterar Cliente\n" +
                    "3 - Listar Clientes Cadastrados\n" +
                    "4 - Visualizar Cliente\n" +
                    "x - Voltar\n" + RESET);
            scanner = new Scanner(System.in);
            String opcao = scanner.nextLine();
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
                    System.out.println("Opção inválida! Voltando...");
            }
        }
    }

    private static void cadastrar() {
        ClienteController clienteControler = new ClienteController();

        try {
            System.out.println("Informe o nome:");
            String nome = scanner.nextLine();
            System.out.println("Informe o telefone:");
            String telefone = scanner.nextLine();
            System.out.println("Informe o CPF:");
            String cpf = scanner.nextLine();
            Cliente cliente = new Cliente(nome, telefone, cpf);
            System.out.println("Informe uma observação ou tecle enter para continuar:");
            String observacao = scanner.nextLine();
            cliente.setObservacao(observacao);
            cliente.setStatus(true);
            cliente.setCriadoEm(new Date());
            cliente.setCriadoPor(null);
            cliente.setAlteradoEm(new Date());
            cliente.setAlteradoPor(null);
            clienteControler.inserir(cliente);
            System.out.println("Cliente inserido com sucesso!\n");
            System.out.println("Pressione enter para continuar...");
            scanner.nextLine();
        } catch(InputMismatchException e){
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Um erro ocorreu!\nCadastro não finalizado...");
        }
    }

    private static void atualizar() {
        ClienteController clienteControler = new ClienteController();

        try {
            System.out.println("Informe o CPF do cliente que deseja alterar:");
            String cpf = scanner.nextLine();
            Cliente clienteAntigo = clienteControler.buscaClientePorCpf(cpf);
            if (clienteAntigo != null) {
                System.out.println(AMARELO + "CLIENTE SELECIONADO" + RESET);
                imprimeCliente(clienteAntigo);
                System.out.println("Informe o nome:");
                String nome = scanner.nextLine();
                System.out.println("Informe o telefone:");
                String telefone = scanner.nextLine();
                Cliente novoCliente = new Cliente(nome, telefone, cpf);
                System.out.println("Informe uma observação ou tecle enter para continuar:");
                String observacao = scanner.nextLine();
                novoCliente.setObservacao(observacao);
                novoCliente.setStatus(true);
                novoCliente.setCriadoEm(clienteAntigo.getCriadoEm());
                novoCliente.setCriadoPor(clienteAntigo.getCriadoPor());
                novoCliente.setAlteradoEm(new Date());
                novoCliente.setAlteradoPor(null);
                clienteControler.atualizar(novoCliente);
                System.out.println("Cliente atualizado com sucesso!\n");
            } else {
                System.out.println("Cliente não encontrado!");
            }
            System.out.println("Pressione enter para continuar...");
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Dado informado inválido!\nCadastro não finalizado...");
        }
    }

    private static void pesquisarClientePorCpf() {
        ClienteController clienteControler = new ClienteController();

        try {
            System.out.println("Informe o cpf de cliente:");
            Cliente cliente = clienteControler.buscaClientePorCpf(scanner.nextLine());
            if (cliente != null) {
                System.out.println(AMARELO + "DADOS DO CLIENTE:" + RESET);
                imprimeCliente(cliente);
                System.out.println("Pressione enter para continuar...");
                scanner.nextLine();
            } else {
                System.out.println("Cliente não encontrado com o cpf informado!");
            }

        } catch (Exception e) {
            System.out.println("Dado informado inválido!\nCadastro não finalizado...");
        }
    }

    private static void imprimeCliente(Cliente cliente) {
        System.out.println(AMARELO + "Nome: " + cliente.getNome() +
                "\nTelefone: " + cliente.getTelefone() +
                "\nCPF: " + cliente.getCpf() +
                "\nStatus: " + (cliente.getStatus() ? "Ativo" : "Inativo") +
                "\n" + RESET);
    }

    private static void listarClientes() {
        ClienteController clienteControler = new ClienteController();
        System.out.println(AMARELO + "LISTA DE CLIENTES:\n" + RESET);
        for (Cliente cliente : clienteControler.pegarLista()) {
            System.out.println(AMARELO + "Nome: " + cliente.getNome() +
                    " CPF: " + cliente.getCpf() +
                    " Telefone: " + cliente.getTelefone() +
                    " Status: " + (cliente.getStatus() ? "Ativo" : "Inativo") +
                    "" + RESET);
        }
        System.out.println("\nPressione enter para continuar...");
        scanner.nextLine();
    }
}
