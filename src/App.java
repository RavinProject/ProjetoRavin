import javax.swing.JOptionPane;

import dao.dados.GerarClientes;
import dao.dados.GerarFuncionarios;
import views.CadastroCliente;
import views.CadastroFuncionario;
import views.menus.PrincipalMenu;

public class App {

    public static final String RESET = "\u001B[0m";
    public static final String VERMELHO = "\u001B[31m";
    public static final String VERDE = "\u001B[32m";
    public static final String AMARELO = "\u001B[33m";

    public static void main(String[] args) {
        
        GerarFuncionarios.montaLista();
        GerarClientes.montaLista();

        System.out.println("\u001B[38;2;255;0;0m\n         :::::::::          :::       :::     :::    :::::::::::     ::::    :::"+ RESET);
        System.out.println("\u001B[38;2;255;165;0m        :+:    :+:       :+: :+:     :+:     :+:        :+:         :+:+:   :+:"+ RESET);
        System.out.println("\u001B[38;2;255;255;0m       +:+    +:+      +:+   +:+    +:+     +:+        +:+         :+:+:+  +:+"+ RESET);
        System.out.println("\u001B[38;2;0;255;0m      +#++:++#:      +#++:++#++:   +#+     +:+        +#+         +#+ +:+ +#+"+ RESET);
        System.out.println("\u001B[38;2;0;255;255m     +#+    +#+     +#+     +#+    +#+   +#+         +#+         +#+  +#+#+#"+ RESET);
        System.out.println("\u001B[38;2;0;0;255m    #+#    #+#     #+#     #+#     #+#+#+#          #+#         #+#   #+#+#"+ RESET);
        System.out.println("\u001B[38;2;0;0;139m   ###    ###     ###     ###       ###        ###########     ###    ####"+ RESET);
        System.out.println(VERMELHO + "\n BEM VINDO AO SISTEMA RAVIN!\n" + RESET);

        menu();
    }

    private static void menu() {
        boolean exec = true;
        while (exec) {
            String opcao = JOptionPane.showInputDialog(PrincipalMenu.inicial());
            if(opcao == null){
                continue;
            }
            switch (opcao) {
                case "1":
                    CadastroCliente.menu();
                    break;
                case "2":
                    CadastroFuncionario.menu();
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
}
