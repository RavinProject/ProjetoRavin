package org.ravin.views.reserva;

import org.ravin.controllers.interfaces.IClienteController;
import org.ravin.controllers.interfaces.IMesaController;
import org.ravin.controllers.interfaces.IReservaController;
import org.ravin.models.Cliente;
import org.ravin.models.Mesa;
import org.ravin.models.Reserva;
import org.ravin.utils.DateUtils;

import java.util.Date;
import java.util.List;

import static org.ravin.views.View.exibeDialogo;
import static org.ravin.views.View.solicitaEntradaDeDado;
import static org.ravin.views.reserva.SubmenuReserva.imprimeReserva;

public class AtualizarReservaView {
    static void atualizar(IReservaController reservaController, IClienteController clienteController, IMesaController mesaController) {

        try {
            String cpfCliente = solicitaEntradaDeDado("Informe o CPF do cliente para listar suas reservas:");
            Cliente cliente = clienteController.recuperarPorCpf(cpfCliente);

            if (cliente != null) {
                List<Reserva> reservas = reservaController.recuperarPorCliente(cliente);
                if (reservas.isEmpty()) {
                    exibeDialogo("Nenhuma reserva encontrada para este cliente!");
                    return;
                }

                exibeDialogo("Reservas:");
                for (int i = 0; i < reservas.size(); i++) {
                    exibeDialogo((i+1) + ". " + reservas.get(i).toString());
                }

                int escolha = Integer.parseInt(solicitaEntradaDeDado("Selecione o número da reserva que deseja alterar:"));
                Reserva reserva = reservas.get(escolha - 1);

                String codigoMesa = solicitaEntradaDeDado("ID da Mesa:", String.valueOf(reserva.getMesa().getId()));
                Mesa mesa = mesaController.recuperarPorCodigo(codigoMesa);
                if (mesa != null) {
                    reserva.setMesa(mesa);
                } else {
                    exibeDialogo("Mesa não encontrada!");
                    return;
                }

                reserva.setData(DateUtils.stringToDate(solicitaEntradaDeDado("Data da reserva: \nFormato: dd/mm/yyyy", DateUtils.dateToString(reserva.getData()))));
                reserva.setCriadoPor(solicitaEntradaDeDado("Criado por:", reserva.getCriadoPor()));
                reserva.setAlteradoEm(new Date());
                reserva.setAlteradoPor(solicitaEntradaDeDado("Alterado por:", reserva.getAlteradoPor()));
                reservaController.atualizar(reserva);
                exibeDialogo("Reserva atualizada com sucesso!");
                imprimeReserva(reservaController.recuperarPorId(reserva.getId()));
            } else {
                exibeDialogo("Cliente não encontrado!");
            }
        } catch (Exception e) {
            exibeDialogo("Dado informado inválido!\nAtualização não finalizada...");
            e.printStackTrace();
        }
    }
}
