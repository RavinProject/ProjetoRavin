import views.cardapio.SubmenuCardapio;
import views.cliente.SubmenuCliente;
import views.comanda.SubmenuComanda;
import views.estoque.SubmenuEstoque;
import views.funcionario.SubmenuFuncionario;
import views.mesa.SubmenuMesa;

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
            String opcao = views.View.solicitaEntradaDeDado(menuInicial());
            if(opcao == null){
                continue;
            }
            switch (opcao) {
                case "1" -> SubmenuCliente.menu();
                case "2" -> SubmenuFuncionario.menu();
                case "3" -> SubmenuEstoque.menu();
                case "4" -> SubmenuMesa.menu();
                case "5" -> SubmenuComanda.menu();
                case "6" -> SubmenuCardapio.menu();
                case "x" -> exec = false;
                default -> System.out.println("Opção inválida!");
            }
        }
        System.out.println("Programa encerrando...");
    }

    public static String menuInicial(){
        StringBuilder builder = new StringBuilder();
        builder.append("""
                ==================== RAVIN ====================
                HOME:
                1 - Clientes
                2 - Funcionários
                3 - Estoque 
                4 - Mesas
                5 - Comandas
                6 - Cardápio
                x - voltar
                """);
        return builder.toString();
    }
}
