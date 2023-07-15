package views.comanda;

import views.View;

public class SubmenuComanda extends View{

    public static void menu() {

        // Injeção de Dependência

        // TODO
        boolean exec = true;
        while (exec) {
            String opcao = solicitaEntradaDeDado(menuInicial());
            switch (opcao) {
                case "1" -> exibeDialogo("Abrir Comanda: implementar...");
                case "2" -> exibeDialogo("Consultar Comanda: implementar...");
                case "3" -> exibeDialogo("Adicionar Pedido: implementar...");
                case "4" -> menuPedido();
                case "5" -> exibeDialogo("Fechar Comanda: implementar...");
                case "6" -> exibeDialogo("Pagar Comanda: implementar...");
                case "x" -> exec = false;
                default -> exibeDialogo("Opção inválida! Voltando...");
            }
        }
    }

    private static String menuInicial() {
        StringBuilder builder = new StringBuilder();
        builder.append("""
                ==================== RAVIN ====================
                COMANDA:
                1 - Abrir Comanda
                2 - Consultar Comanda
                3 - Adicionar Pedido
                4 - Alterar Pedido
                5 - Fechar Comanda
                6 - Pagar Comanda
                x - voltar
                """);
        return builder.toString();
    }

    public static void menuPedido() {

        // TODO
        boolean exec = true;
        while (exec) {
            String opcao = solicitaEntradaDeDado(textMenuPedido());
            switch (opcao) {
                case "1" -> exibeDialogo("Pedido: Alterar Quantidade: implementar...");
                case "2" -> exibeDialogo("Pedido: Alterar Produto: implementar...");
                case "3" -> exibeDialogo("Pedido: Excluir Pedido: implementar...");
                case "x" -> exec = false;
                default -> exibeDialogo("Opção inválida! Voltando...");
            }
        }
    }
    
    private static String textMenuPedido() {
        StringBuilder builder = new StringBuilder();
        builder.append("""
                ==================== RAVIN ====================
                PEDIDO:
                1 - Alterar Quantidade
                2 - Alterar Produto
                3 - Excluir Pedido
                x - voltar
                """);
        return builder.toString();
    }
}
