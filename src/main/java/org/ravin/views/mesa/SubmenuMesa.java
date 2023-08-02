package org.ravin.views.mesa;

import org.ravin.controllers.MesaController;
import org.ravin.controllers.interfaces.IMesaController;
import org.ravin.models.Mesa;
import org.ravin.services.MesaService;
import org.ravin.services.interfaces.IMesaService;
import org.ravin.views.View;

import static org.ravin.views.mesa.AtualizarMesaView.atualizarMesa;
import static org.ravin.views.mesa.CadastrarMesaView.cadastrarMesa;
import static org.ravin.views.mesa.ExcluirMesaView.excluirMesa;
import static org.ravin.views.mesa.RecuperarMesaView.listarMesas;
import static org.ravin.views.mesa.RecuperarMesaView.recuperarMesaPorCodigo;

public class SubmenuMesa extends View{

    public static void menuMesa(){
        // Injeção de Dependência
        IMesaService mesaService = new MesaService();
        IMesaController mesaController = new MesaController(mesaService);

        boolean exec = true;
        while (exec) {
            String opcao = solicitaEntradaDeDado(menuInicial());
            switch (opcao) {
                case "1" -> cadastrarMesa(mesaController);
                case "2" -> atualizarMesa(mesaController);
                case "3" -> excluirMesa(mesaController);
                case "4" -> listarMesas(mesaController);
                case "5" -> recuperarMesaPorCodigo(mesaController);
                case "x" -> exec = false;
                default -> exibeDialogo("Opção inválida! Voltando...");
            }
        }
    }

    private static String menuInicial(){
        return """
                ==================== RAVIN ====================
                MESA:
                1 - Criar uma Mesa
                2 - Alterar uma Mesa
                3 - Excluir uma Mesa
                4 - Listar todas as Mesas
                5 - Recuperar Mesa por Código
                x - voltar
                """;
    }

    static void imprimeMesa(Mesa mesa) {
        String mesaDados =
                "ID: " + mesa.getId() +
                        "\n Código: " + mesa.getCodigo() +
                        "\n Número: " + mesa.getNumero() +
                        "\n Funcionário responsável: " + (mesa.getFuncionario() != null ? mesa.getFuncionario().getNome() : "N/A") +
                        "\n Quantidade Máxima: " + mesa.getQuantidadeMaxima() +
                        "\n Status: " + mesa.getStatusMesa().toString() +
                        "\n Criado Em: " + mesa.getCriadoEm() +
                        "\n Criado Por: " + mesa.getCriadoPor() +
                        "\n Alterado Em: " + mesa.getAlteradoEm() +
                        "\n Alterado Por: " + mesa.getAlteradoPor();

        exibeDialogo(mesaDados);
    }
}
