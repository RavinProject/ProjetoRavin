package org.ravin.dao.interfaces;

import org.ravin.models.Cliente;
import org.ravin.models.Mesa;
import org.ravin.models.Reserva;
import org.ravin.utils.interfaces.IGeradorId;

import java.util.List;

public interface IReservaRepositorio extends IRepositorio<Reserva>, IGeradorId<Reserva> {
    List<Reserva> getReservasPorCliente(Cliente cliente);
    List<Reserva> getReservasPorMesa(Mesa mesa);
}
