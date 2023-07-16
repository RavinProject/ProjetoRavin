package org.ravin.views.cardapio;

import org.ravin.views.View;

public class SubmenuCardapio extends View{

    public static void menu() {

        // Injeção de Dependência

        // TODO
        boolean exec = true;
        while (exec) {
            String opcao = solicitaEntradaDeDado(menuInicial());
            switch (opcao) {
                case "1" -> exibeDialogo("Consultar Cardápio: implementar...");
                case "2" -> exibeDialogo("Criar Cardápio: implementar...");
                case "3" -> exibeDialogo("Atualizar Cardápio: implementar...");
                case "4" -> exibeDialogo("Excluir Cardápio: implementar...");
                case "x" -> exec = false;
                default -> exibeDialogo("Opção inválida! Voltando...");
            }
        }
    }

    private static String menuInicial() {
        StringBuilder builder = new StringBuilder();
        builder.append("""
                ==================== RAVIN ====================
                CARDÁPIO:
                1 - Consultar Cardápio
                2 - Criar Cardápio
                3 - Atualizar Cardápio
                4 - Excluir Cardápio
                x - voltar
                """);
        return builder.toString();
    }
}
