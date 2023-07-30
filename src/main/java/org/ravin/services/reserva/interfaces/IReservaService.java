package org.ravin.services.reserva.interfaces;

import org.ravin.models.Cliente;
import org.ravin.models.Mesa;
import org.ravin.models.Reserva;
import org.ravin.utils.exceptions.MesaNaoDisponivelException;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IReservaService {

    void inserir(Reserva reserva) throws MesaNaoDisponivelException;

    Optional<Reserva> recuperarPorId(int id);


    List<Reserva> recuperarTodos();


    void atualizar(Reserva reserva);


    boolean remover(Reserva reserva);

    List<Reserva> recuperarReservasPorCliente(Cliente cliente);

    List<Reserva> recuperarReservasPorMesa(Mesa mesa);

    boolean estaDisponivel(Date data);
}
