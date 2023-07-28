package org.ravin.services.interfaces;

import org.ravin.models.Cliente;
import org.ravin.models.Mesa;
import org.ravin.models.Reserva;

import java.util.Date;

public interface IReservaService extends IService<Reserva> {
    public void reservar(Cliente cliente, Mesa mesa, Date data);
    public boolean estaDisponivel(Date data);
}
