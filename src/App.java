import javax.swing.JOptionPane;

import dao.dados.GerarClientes;
import dao.dados.GerarFuncionarios;
import views.CadastroClienteView;
import views.CadastroEstoqueView;
import views.CadastroFuncionarioView;

public class App {

    public static void main(String[] args) {
        
        GerarFuncionarios.montaLista();
        GerarClientes.montaLista();

        System.out.println("\u001B[38;2;255;0;0m\n         :::::::::          :::       :::     :::    :::::::::::     ::::    :::\u001B[0m");
        System.out.println("\u001B[38;2;255;165;0m        :+:    :+:       :+: :+:     :+:     :+:        :+:         :+:+:   :+:\u001B[0m");
        System.out.println("\u001B[38;2;255;255;0m       +:+    +:+      +:+   +:+    +:+     +:+        +:+         :+:+:+  +:+\u001B[0m");
        System.out.println("\u001B[38;2;0;255;0m      +#++:++#:      +#++:++#++:   +#+     +:+        +#+         +#+ +:+ +#+\u001B[0m");
        System.out.println("\u001B[38;2;0;255;255m     +#+    +#+     +#+     +#+    +#+   +#+         +#+         +#+  +#+#+#\u001B[0m");
        System.out.println("\u001B[38;2;0;0;255m    #+#    #+#     #+#     #+#     #+#+#+#          #+#         #+#   #+#+#\u001B[0m");
        System.out.println("\u001B[38;2;0;0;139m   ###    ###     ###     ###       ###        ###########     ###    ####\u001B[0m");
        System.out.println("\u001B[31m \n BEM VINDO AO SISTEMA RAVIN!\n\u001B[0m");

        menu();
    }

    private static void menu() {
        boolean exec = true;
        while (exec) {
            String opcao = JOptionPane.showInputDialog(menuInicial());
            if(opcao == null){
                continue;
            }
            switch (opcao) {
                case "1":
                    CadastroClienteView.menu();
                    break;
                case "2":
                    CadastroFuncionarioView.menu();
                    break;
                case "3":
                    CadastroEstoqueView.menu();
                    break;
                case "x":
                    exec = false;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
        System.out.println("Programa encerrando...");
    }

    public static String menuInicial(){
        StringBuilder builder = new StringBuilder();
		builder.append(" ==================== RAVIN ==================== ");
		builder.append("\n");
		builder.append("1 - Clientes \n");
		builder.append("2 - Funcionarios \n");
		builder.append("3 - Estoque \n");
		// builder.append("4 - Mesas \n");
		// builder.append("5 - Mesas \n");
		// builder.append("6 - Pedidos \n");
		builder.append("x - Sair");
        return builder.toString();
    }
}
