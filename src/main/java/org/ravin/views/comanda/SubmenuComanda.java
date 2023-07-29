package org.ravin.views.comanda;

import org.ravin.controllers.ComandaController;
import org.ravin.controllers.interfaces.IComandaController;
import org.ravin.dao.ListasDados;
import org.ravin.dao.interfaces.IComandaRepositorioLista;
import org.ravin.services.comanda.ComandaService;
import org.ravin.services.comanda.PagarComandaService;
import org.ravin.services.comanda.interfaces.IComandaService;
import org.ravin.services.comanda.interfaces.IPagarComandaService;
import org.ravin.strategy.DescontoFactory;
import org.ravin.strategy.interfaces.IDescontoFactory;
import org.ravin.views.View;

public class SubmenuComanda extends View{

    public static void menuComanda() {

        // Injeção de Dependência
        // Lista
        IComandaRepositorioLista comandaRepository = ListasDados.getInstance().getComandaRepositorio();
        // Fábrica de descontos
        IDescontoFactory descontoFactory = new DescontoFactory();
        // Services de comanda
        IPagarComandaService pagarComandaService = new PagarComandaService(comandaRepository, descontoFactory);
        IComandaService comandaService = new ComandaService();
        // Controller
        IComandaController comandaController = new ComandaController(pagarComandaService, comandaService);

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
        String builder = """
                ==================== RAVIN ====================
                COMANDA:
                1 - Abrir Comanda
                2 - Consultar Comanda
                3 - Adicionar Pedido
                4 - Alterar Pedido
                5 - Fechar Comanda
                6 - Pagar Comanda
                x - voltar
                """;
        return builder;
    }

    public static void menuPedido() {

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
        return """
                ==================== RAVIN ====================
                PEDIDO:
                1 - Alterar Quantidade
                2 - Alterar Produto
                3 - Excluir Pedido
                x - voltar
                """;
    }
}
