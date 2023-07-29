package org.ravin.controllers.interfaces;

import org.ravin.models.Cliente;
import org.ravin.models.Mesa;
import org.ravin.models.Reserva;

import java.util.Date;
import java.util.List;

public interface IReservaController extends IController<Reserva> {
    void reservarMesa(Cliente cliente, Mesa mesa, Date data);
    List<Reserva> recuperarPorCliente(Cliente cliente);

    Reserva recuperarPorMesa(Mesa mesa);

    List<Reserva> recuperarReservasPorCodigo(String codigoMesa);
}
