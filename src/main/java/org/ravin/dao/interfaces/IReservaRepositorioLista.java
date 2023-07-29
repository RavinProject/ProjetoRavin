package org.ravin.dao.interfaces;

import org.ravin.models.Cliente;
import org.ravin.models.Mesa;
import org.ravin.models.Reserva;

import java.util.List;

public interface IReservaRepositorioLista extends IRepositorioLista<Reserva> {
    List<Reserva> getReservasPorCliente(Cliente cliente);
    List<Reserva> getReservasPorMesa(Mesa mesa);

    default int getId(Reserva reserva){
        return reserva.getId();
    }
}
