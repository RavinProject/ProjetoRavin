package org.ravin;

import org.ravin.utils.constants.Constants;
import org.ravin.views.cardapio.SubmenuCardapio;
import org.ravin.views.cliente.SubmenuCliente;
import org.ravin.views.comanda.SubmenuComanda;
import org.ravin.views.estoque.SubmenuEstoque;
import org.ravin.views.funcionario.SubmenuFuncionario;
import org.ravin.views.mesa.SubmenuMesa;
import org.ravin.views.reserva.SubmenuReserva;

import static org.ravin.views.View.*;

import static org.ravin.views.View.solicitaEntradaDeDado;

public class App {

    public static void main(String[] args) {
        printLogotipo();
        System.out.println(Constants.BEM_VINDO);
        mainMenu();
    }

    // Função para imprimir o logotipo
    private static void printLogotipo() {
        for (String linha : Constants.LOGOTIPO) {
            System.out.println(linha);
        }
    }

    private static void mainMenu() {
        boolean exec = true;
        while (exec) {
            String opcao = solicitaEntradaDeDado(menuInicial());
            if(opcao == null){
                continue;
            }
            // Encapsula a lógica de seleção em uma função separada
            exec = processaOpcaoMenu(opcao);
        }
        System.out.println("Programa encerrando...");
    }

    // Função para processar a opção do menu selecionada pelo usuário
    private static boolean processaOpcaoMenu(String opcao) {
        switch (opcao) {
            case "1" -> {
                SubmenuCliente.menuCliente();
                return true;
            }
            case "2" -> {
                SubmenuFuncionario.menuFuncionario();
                return true;
            }
            case "3" -> {
                SubmenuEstoque.menuEstoque();
                return true;
            }
            case "4" -> {
                SubmenuMesa.menuMesa();
                return true;
            }
            case "5" -> {
                SubmenuComanda.menuComanda();
                return true;
            }
            case "6" -> {
                SubmenuCardapio.menuCardapio();
                return true;
            }
            case "x" -> {
                return false;
            }
            default -> {
                System.out.println("Opção inválida!");
                return true;
            }
        }
    }
    public static String menuInicial(){
        return """
                ==================== RAVIN ====================
                HOME:
                1 - Clientes
                2 - Funcionários
                3 - Estoque
                4 - Mesas
                5 - Comandas
                6 - Cardápio
                x - voltar
                """;
    }
}
