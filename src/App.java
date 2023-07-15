import javax.swing.JOptionPane;

import views.cliente.SubmenuCliente;
import views.estoque.SubmenuEstoque;
import views.funcionario.CadastroFuncionarioView;

public class App {

    public static void main(String[] args) {

        System.out.println("\u001B[38;2;255;0;0m\n         :::::::::          :::       :::     :::    :::::::::::     ::::    :::\u001B[0m");
        System.out.println("\u001B[38;2;255;165;0m        :+:    :+:       :+: :+:     :+:     :+:        :+:         :+:+:   :+:\u001B[0m");
        System.out.println("\u001B[38;2;255;255;0m       +:+    +:+      +:+   +:+    +:+     +:+        +:+         :+:+:+  +:+\u001B[0m");
        System.out.println("\u001B[38;2;0;255;0m      +#++:++#:      +#++:++#++:   +#+     +:+        +#+         +#+ +:+ +#+\u001B[0m");
        System.out.println("\u001B[38;2;0;255;255m     +#+    +#+     +#+     +#+    +#+   +#+         +#+         +#+  +#+#+#\u001B[0m");
        System.out.println("\u001B[38;2;0;0;255m    #+#    #+#     #+#     #+#     #+#+#+#          #+#         #+#   #+#+#\u001B[0m");
        System.out.println("\u001B[38;2;0;0;139m   ###    ###     ###     ###       ###        ###########     ###    ####\u001B[0m");
        System.out.println("\u001B[31m \n BEM VINDO AO SISTEMA RAVIN!\n\u001B[0m");

        mainMenu();
    }

    private static void mainMenu() {
        boolean exec = true;
        while (exec) {
            String opcao = JOptionPane.showInputDialog(menuInicial());
            if(opcao == null){
                continue;
            }
            switch (opcao) {
                case "1" -> SubmenuCliente.menu();
                case "2" -> CadastroFuncionarioView.menu();
                case "3" -> SubmenuEstoque.menu();
                case "x" -> exec = false;
                default -> System.out.println("Opção inválida!");
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
