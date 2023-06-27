package views;

import java.util.Scanner;

public class Cadastro extends View{

    private static Scanner scanner;

    public static void menu(){
        System.out.println(VERDE + "Selecione a opção desejada:\n" +
        "1 - Cadastro Cliente\n" +
        "2 - Cadastro Funcionario\n" +
        "3 - Cadastro Produto\n" +
        "4 - Cadastro Estoque\n" +
        "5 - Cadastro Pedido\n" +
        "6 - Cadastro Comanda\n" +
        "7 - Cadastro Mesa\n" + RESET);
        scanner = new Scanner(System.in);
        String opcao = scanner.nextLine();
        switch(opcao){
            case "1" : CadastroCliente.menu(); break;
            case "2" : CadastroFuncionario.menu(); break;
            default : System.out.println("Opção inválida!");
        }
    }

    
}
