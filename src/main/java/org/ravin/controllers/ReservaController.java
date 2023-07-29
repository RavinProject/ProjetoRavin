package org.ravin.controllers;

import org.ravin.controllers.interfaces.IReservaController;
import org.ravin.models.Cliente;
import org.ravin.models.Mesa;
import org.ravin.models.Reserva;
import org.ravin.services.interfaces.IReservaService;

import java.util.Date;
import java.util.List;

public class ReservaController implements IReservaController {

    // Injeção de dependência
    private final IReservaService reservaService;
    public ReservaController(IReservaService reservaService) {
        this.reservaService = reservaService;
    }
    @Override
    public void inserir(Reserva reserva) {
        reservaService.inserir(reserva);
    }

    @Override
    public Reserva recuperarPorId(int id) {
        return null;
    }

    @Override
    public List<Reserva> recuperarTodos() {
        return reservaService.recuperarTodos();
    }

    @Override
    public void atualizar(Reserva objeto) {

    }

    @Override
    public boolean remover(Reserva objeto) {
        return false;
    }

    @Override
    public void reservarMesa(Cliente cliente, Mesa mesa, Date data) {

    }

    @Override
    public List<Reserva> recuperarPorCliente(Cliente cliente) {
        return null;
    }

    @Override
    public Reserva recuperarPorMesa(Mesa mesa) {
        return null;
    }

    @Override
    public List<Reserva> recuperarReservasPorCodigo(String codigoMesa) {
        return null;
    }
}
