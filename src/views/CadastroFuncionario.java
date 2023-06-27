package views;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import controllers.FuncionarioController;
import models.Funcionario;

public class CadastroFuncionario extends View {
    
    private static Scanner scanner;

    public static void menu() {
        boolean exec = true;
        while (exec) {
            System.out.println(VERDE + "Selecione a opção desejada:\n" +
                    "1 - Cadastrar Funcionário\n" +
                    "2 - Alterar Funcionário\n" +
                    "3 - Listar Funcionários Cadastrados\n" +
                    "4 - Visualizar Funcionário\n" +
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

        private static void cadastrar() {
            FuncionarioController funcionarioController = new FuncionarioController();
    
            try {
                System.out.println("Informe o nome:");
                String nome = scanner.nextLine();
                System.out.println("Informe o telefone:");
                String telefone = scanner.nextLine();
                System.out.println("Informe o CPF:");
                String cpf = scanner.nextLine();
                Funcionario funcionario = new Funcionario(nome, telefone, cpf);
                funcionario.setStatus(true);
                funcionario.setCriadoEm(new Date());
                funcionario.setCriadoPor(null);
                funcionario.setAlteradoEm(new Date());
                funcionario.setAlteradoPor(null);
                funcionarioController.inserir(funcionario);
                System.out.println("Cliente inserido com sucesso!\n");
                System.out.println("Pressione enter para continuar...");
                scanner.nextLine();
            } catch(InputMismatchException e){
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Um erro ocorreu!\nCadastro não finalizado...");
            }
        }
}
