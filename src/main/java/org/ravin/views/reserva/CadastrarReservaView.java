package org.ravin.views.reserva;

import org.ravin.controllers.interfaces.IClienteController;
import org.ravin.controllers.interfaces.IMesaController;
import org.ravin.controllers.interfaces.IReservaController;
import org.ravin.models.Cliente;
import org.ravin.models.Mesa;
import org.ravin.models.Reserva;
import org.ravin.utils.DateUtils;
import org.ravin.utils.exceptions.EntidadeNaoEncontradaException;
import org.ravin.utils.exceptions.MesaNaoDisponivelException;

import java.util.Date;

import static org.ravin.views.View.exibeDialogo;
import static org.ravin.views.View.solicitaEntradaDeDado;
import static org.ravin.views.reserva.SubmenuReserva.imprimeReserva;

public class CadastrarReservaView {
    static void cadastrarReserva(IReservaController reservaController, IClienteController clienteController, IMesaController mesaController) {
        try {
            String cpfCliente = solicitaEntradaDeDado("Informe o CPF do cliente:");
            Cliente cliente = clienteController.recuperarPorCpf(cpfCliente);

            String codigo = solicitaEntradaDeDado("Informe o Código da mesa:");
            Mesa mesa = mesaController.recuperarPorCodigo(codigo);

            Date data = DateUtils.stringToDate(solicitaEntradaDeDado("Data da reserva: \nFormato: dd/mm/yyyy"));

            Reserva reserva = new Reserva(cliente,mesa, data);

            reserva.setCriadoPor(solicitaEntradaDeDado("Criado por:"));
            reserva.setAlteradoEm(new Date());
            reservaController.inserir(reserva);
            exibeDialogo("Reserva inserida com sucesso!");
            imprimeReserva(reserva);
        } catch(EntidadeNaoEncontradaException | MesaNaoDisponivelException e) {
            exibeDialogo(e.getMessage());
        } catch (Exception e) {
            exibeDialogo("Um erro ocorreu!\nCadastro não finalizado...");
            e.printStackTrace();
        }
    }
}