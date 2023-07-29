package org.ravin.services.interfaces;

import org.ravin.models.Cliente;
import org.ravin.models.Mesa;
import org.ravin.models.Reserva;
import org.ravin.utils.exceptions.MesaNaoDisponivelException;

import java.util.Date;

public interface IReservaService extends IService<Reserva> {
    void reservar(Cliente cliente, Mesa mesa, Date data) throws MesaNaoDisponivelException;
    boolean estaDisponivel(Date data);
}
