package org.ravin.views.reserva;

import org.ravin.controllers.interfaces.IClienteController;
import org.ravin.controllers.interfaces.IMesaController;
import org.ravin.controllers.interfaces.IReservaController;
import org.ravin.models.Cliente;
import org.ravin.models.Mesa;
import org.ravin.models.Reserva;
import org.ravin.utils.DateUtils;
import org.ravin.utils.exceptions.EntidadeNaoEncontradaException;

import java.util.Date;
import java.util.InputMismatchException;

import static org.ravin.views.View.exibeDialogo;
import static org.ravin.views.View.solicitaEntradaDeDado;
import static org.ravin.views.reserva.SubmenuReserva.imprimeReserva;

public class CadastrarReservaView {
    static void cadastrar(IReservaController reservaController, IClienteController clienteController, IMesaController mesaController) {
        Reserva reserva = new Reserva();
        try {
            String cpfCliente = solicitaEntradaDeDado("Informe o CPF do cliente:");
            Cliente cliente = clienteController.recuperarPorCpf(cpfCliente);
            if (cliente != null) {
                reserva.setCliente(cliente);
            } else {
                exibeDialogo("Cliente não encontrado!");
                return;
            }

            String codigo = solicitaEntradaDeDado("Informe o ID da mesa:");
            Mesa mesa = mesaController.recuperarPorCodigo(codigo);
            if (mesa != null) {
                reserva.setMesa(mesa);
            } else {
                exibeDialogo("Mesa não encontrada!");
                return;
            }

            reserva.setData(DateUtils.stringToDate(solicitaEntradaDeDado("Data da reserva: \nFormato: dd/mm/yyyy")));
            reserva.setCriadoPor(solicitaEntradaDeDado("Criado por:"));
            reserva.setAlteradoEm(new Date());
            reservaController.inserir(reserva);
            exibeDialogo("Reserva inserida com sucesso!");
            imprimeReserva(reservaController.recuperarPorId(reserva.getId()));
        } catch(InputMismatchException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            exibeDialogo("Um erro ocorreu!\nCadastro não finalizado...");
            e.printStackTrace();
        } catch (EntidadeNaoEncontradaException e) {
            throw new RuntimeException(e);
        }
    }
}
