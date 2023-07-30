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
import static org.ravin.views.cliente.CadastrarClienteView.cadastrarCliente;
import static org.ravin.views.reserva.SubmenuReserva.imprimeReserva;

public class CadastrarReservaView {
    static void cadastrarReserva(IReservaController reservaController, IClienteController clienteController, IMesaController mesaController) {
        Cliente cliente = new Cliente();
        try {
            String cpfCliente = solicitaEntradaDeDado("Informe o CPF do cliente:");
            cliente = clienteController.recuperarPorCpf(cpfCliente);
            if (cliente == null) {
                exibeDialogo("Cliente não encontrado! Vamos cadastrá-lo agora.");
                cadastrarCliente(clienteController);
                cliente = clienteController.recuperarPorCpf(cpfCliente);
                if (cliente == null) {
                    exibeDialogo("Ocorreu um erro ao tentar cadastrar o cliente. Tente novamente.");
                    return;
                }
            }

            String codigo = solicitaEntradaDeDado("Informe o Código da mesa:");
            Mesa mesa = mesaController.recuperarPorCodigo(codigo);
            if (mesa == null) {
                exibeDialogo("Mesa não encontrada!");
            }

            Date data = DateUtils.stringToDate(solicitaEntradaDeDado("Data da reserva: \nFormato: dd/mm/yyyy"));

            Reserva reserva = new Reserva(cliente,mesa, data);

            reserva.setCriadoPor(solicitaEntradaDeDado("Criado por:"));
            reserva.setAlteradoEm(new Date());
            reservaController.inserir(reserva);
            exibeDialogo("Reserva inserida com sucesso!");
            imprimeReserva(reserva);
        } catch(EntidadeNaoEncontradaException e) {
            e.printStackTrace();
        } catch(InputMismatchException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            exibeDialogo("Um erro ocorreu!\nCadastro não finalizado...");
            e.printStackTrace();
        }
    }
}