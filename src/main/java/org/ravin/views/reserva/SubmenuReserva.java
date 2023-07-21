package org.ravin.views.reserva;

import org.ravin.controllers.ClienteController;
import org.ravin.controllers.MesaController;
import org.ravin.controllers.ReservaController;
import org.ravin.controllers.interfaces.IClienteController;
import org.ravin.controllers.interfaces.IMesaController;
import org.ravin.controllers.interfaces.IReservaController;
import org.ravin.models.Reserva;
import org.ravin.services.ClienteService;
import org.ravin.services.MesaService;
import org.ravin.services.ReservaService;
import org.ravin.services.interfaces.IClienteService;
import org.ravin.services.interfaces.IMesaService;
import org.ravin.services.interfaces.IReservaService;
import org.ravin.utils.DateUtils;
import org.ravin.views.View;

import static org.ravin.views.reserva.CadastrarReservaView.cadastrar;

public class SubmenuReserva extends View {
    public static void menu(){

        // Injeção de Dependência
        IReservaService reservaService = new ReservaService();
        IReservaController reservaController = new ReservaController(reservaService);

        IMesaService mesaService = new MesaService();
        IMesaController mesaController = new MesaController(mesaService);

        IClienteService clienteServico = new ClienteService();
        IClienteController clienteController = new ClienteController(clienteServico);

        // TODO
        boolean exec = true;
        while (exec) {
            String opcao = solicitaEntradaDeDado(menuInicial());
            switch (opcao) {
                case "1" -> cadastrar(reservaController, clienteController, mesaController);
                case "2" -> exibeDialogo("Alterar Reserva: implementar...");
                case "3" -> exibeDialogo("Excluir Reserva: implementar...");
                case "4" -> exibeDialogo("Listar Reserva: implementar...");
                case "5" -> exibeDialogo("Exibir Reserva: implementar...");
                case "6" -> exibeDialogo("Reservar Reserva: implementar...");
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

    static void imprimeReserva(Reserva reserva) {
        String reservaDados = "ID: " + reserva.getId() +
                "\nCliente: " + reserva.getCliente().getNome() +
                "\nMesa: " + reserva.getMesa().getId() + // assumindo que Mesa tem um método getId()
                "\nData: " + DateUtils.dateToString(reserva.getData()) +
                "\nCriado Por: " + reserva.getCriadoPor() +
                "\nAlterado Em: " + DateUtils.dateToString(reserva.getAlteradoEm()) +
                "\nAlterado Por: " + reserva.getAlteradoPor();
        exibeDialogo(reservaDados);
    }

}
