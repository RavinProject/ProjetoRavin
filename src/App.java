import java.util.Scanner;

import views.Cadastro;

public class App {

    public static final String RESET = "\u001B[0m";
    public static final String VERMELHO = "\u001B[31m";
    public static final String VERDE = "\u001B[32m";
    public static final String AMARELO = "\u001B[33m";

    public static void main(String[] args) {

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
        Scanner scanner;
        scanner = new Scanner(System.in);
        boolean exec = true;
        while (exec) {
            System.out.println(VERDE + "#########################################\n" +
                    "Escolha a opção desejada:\n" +
                    "1 - Cadastrar Entidades\n" +
                    "x - Encerrar Programa\n" +
                    "#########################################\n" + RESET);
            String opcao = scanner.nextLine();
            switch (opcao) {
                case "1":
                    Cadastro.menu();
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
