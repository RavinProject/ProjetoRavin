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
import org.ravin.services.interfaces.IClienteService;
import org.ravin.services.interfaces.IMesaService;
import org.ravin.services.reserva.ReservaService;
import org.ravin.services.reserva.VerificarComandaEmMesaService;
import org.ravin.services.reserva.interfaces.IReservaService;
import org.ravin.services.reserva.interfaces.IVerificarComandaEmMesaService;
import org.ravin.utils.DateUtils;
import org.ravin.utils.exceptions.EntidadeNaoEncontradaException;
import org.ravin.views.View;

import static org.ravin.views.reserva.AtualizarReservaView.atualizarReserva;
import static org.ravin.views.reserva.CadastrarReservaView.cadastrarReserva;
import static org.ravin.views.reserva.ExcluirReservaView.excluirReserva;
import static org.ravin.views.reserva.RecuperarReservaView.*;

public class SubmenuReserva extends View {
    public static void menuReserva() throws EntidadeNaoEncontradaException {

        // Injeção de Dependência
        IVerificarComandaEmMesaService verificarComandaEmMesaService = new VerificarComandaEmMesaService();
        IReservaService reservaService = new ReservaService(verificarComandaEmMesaService);
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
                case "1" -> cadastrarReserva(reservaController, clienteController, mesaController);
                case "2" -> atualizarReserva(reservaController, clienteController, mesaController);
                case "3" -> excluirReserva(reservaController);
                case "4" -> listarReservas(reservaController);
                case "5" -> listarReservasPorCliente(reservaController, clienteController);
                case "6" -> listarReservasPorMesa(reservaController, mesaController);
                case "x" -> exec = false;
                default -> exibeDialogo("Opção inválida! Voltando...");
            }
        }
    }

    private static String menuInicial(){
        return """
                ==================== RAVIN ====================
                MESA:
                1 - Criar uma Reserva
                2 - Alterar uma Reserva
                3 - Excluir uma Reserva
                4 - Listar Reservas
                5 - Listar Reservas por Cliente
                6 - Listar Reservas por Mesa
                x - voltar
                """;
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
