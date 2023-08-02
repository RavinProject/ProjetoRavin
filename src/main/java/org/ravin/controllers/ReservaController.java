package org.ravin.controllers;

import org.ravin.controllers.interfaces.IReservaController;
import org.ravin.models.Cliente;
import org.ravin.models.Mesa;
import org.ravin.models.Reserva;
import org.ravin.services.reserva.interfaces.IReservaService;
import org.ravin.utils.exceptions.EntidadeNaoEncontradaException;
import org.ravin.utils.exceptions.MesaNaoDisponivelException;

import java.util.List;
import java.util.Optional;

public class ReservaController implements IReservaController {

    // Injeção de dependência
    private final IReservaService reservaService;
    public ReservaController(IReservaService reservaService) {
        this.reservaService = reservaService;
    }


    @Override
    public void inserir(Reserva reserva) throws MesaNaoDisponivelException {
        try {
            reservaService.inserir(reserva);
        } catch (org.ravin.utils.exceptions.DataIndisponivelException e) {
            throw new RuntimeException(e);
        } catch (org.ravin.utils.exceptions.ComandaEmMesaException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Reserva recuperarPorId(int id) throws EntidadeNaoEncontradaException {
        Optional<Reserva> oReserva = reservaService.recuperarPorId(id);
        if (oReserva.isPresent()) {
            return oReserva.get();
        } else {
            throw new EntidadeNaoEncontradaException("Reserva não encontrada para o ID: " + id);
        }
    }

    @Override
    public List<Reserva> recuperarTodos() {
        return reservaService.recuperarTodos();
    }

    @Override
    public void atualizar(Reserva reserva) {
        reservaService.atualizar(reserva);
    }

    @Override
    public boolean remover(Reserva reserva) {
        try {
            reservaService.remover(reserva);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Reserva> recuperarReservasPorCliente(Cliente cliente) {
        return reservaService.recuperarReservasPorCliente(cliente);
    }

    @Override
    public List<Reserva> recuperarReservasPorMesa(Mesa mesa) {
        return reservaService.recuperarReservasPorMesa(mesa);
    }
}
