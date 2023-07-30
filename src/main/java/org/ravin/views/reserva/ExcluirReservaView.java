package org.ravin.views.reserva;

import org.ravin.controllers.interfaces.IReservaController;
import org.ravin.models.Reserva;

import javax.swing.*;

import static org.ravin.views.View.*;

public class ExcluirReservaView {
    static void excluirReserva(IReservaController reservaController) {
        try {
            int id = Integer.parseInt(solicitaEntradaDeDado("Informe o ID da Reserva que deseja excluir:"));
            if (id <= 0) return;
            Reserva reserva = reservaController.recuperarPorId(id);

            if (reserva != null) {
                String reservaDados = "A seguinte reserva será excluída:" +
                        "\n\nID: " + reserva.getId() +
                        "\nCliente: " + reserva.getCliente().getNome() +
                        "\nMesa: " + reserva.getMesa().getNumero() +
                        "\nData: " + reserva.getData() +
                        "\n\nClique em OK para confirmar ou Cancele.";
                if(confirmaAcao(reservaDados) == JOptionPane.YES_OPTION){
                    boolean excluido = reservaController.remover(reserva);
                    exibeDialogo(excluido ? "A reserva foi removida!" : "Não foi possível excluir a reserva");
                } else {
                    exibeDialogo("Nada foi alterado!");
                }
            } else {
                exibeDialogo("Reserva não encontrada com o ID informado!");
            }
        } catch (Exception e) {
            exibeDialogo("Dado informado inválido!\nExclusão não finalizada...");
            e.printStackTrace();
        }
    }
}
