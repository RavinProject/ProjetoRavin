package org.ravin.views.mesa;

import org.ravin.controllers.ClienteController;
import org.ravin.dao.interfaces.IMesaRepositorio;
import org.ravin.services.ClienteService;
import org.ravin.services.interfaces.IClienteService;
import org.ravin.views.View;

public class SubmenuMesa extends View{

    public static void menu(){
        
        // Injeção de Dependência

        // TODO
        boolean exec = true;
        while (exec) {
            String opcao = solicitaEntradaDeDado(menuInicial());
            switch (opcao) {
                case "1" -> exibeDialogo("Criar Mesa: implementar...");
                case "2" -> exibeDialogo("Alterar Mesa: implementar...");
                case "3" -> exibeDialogo("Excluir Mesa: implementar...");
                case "4" -> exibeDialogo("Listar Mesas: implementar...");
                case "5" -> exibeDialogo("Exibir Mesa: implementar...");
                case "6" -> exibeDialogo("Reservar Mesa: implementar...");
                case "x" -> exec = false;
                default -> exibeDialogo("Opção inválida! Voltando...");
            }
        }
    }

    private static String menuInicial(){
        StringBuilder builder = new StringBuilder();
        builder.append("""
            ==================== RAVIN ====================
            MESA:
            1 - Criar Mesa
            2 - Alterar Mesa
            3 - Excluir Mesa
            4 - Listar Mesas
            5 - Exibir Mesa
            6 - Reservar Mesa
            x - voltar
            """);
        return builder.toString();
    }

}
