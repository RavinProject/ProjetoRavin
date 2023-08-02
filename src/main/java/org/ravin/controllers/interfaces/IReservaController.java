package org.ravin.controllers.interfaces;

import org.ravin.models.Cliente;
import org.ravin.models.Mesa;
import org.ravin.models.Reserva;
import org.ravin.utils.exceptions.EntidadeNaoEncontradaException;
import org.ravin.utils.exceptions.MesaNaoDisponivelException;

import java.util.List;

public interface IReservaController {

    // Separei IReservaController de IServices para não misturar o exception com a assinatura da interface IService

    void inserir(Reserva reserva) throws MesaNaoDisponivelException;
    Reserva recuperarPorId(int id) throws EntidadeNaoEncontradaException;
    List<Reserva> recuperarTodos();
    void atualizar(Reserva reserva) throws EntidadeNaoEncontradaException;
    boolean remover(Reserva reserva) throws EntidadeNaoEncontradaException;

    List<Reserva> recuperarReservasPorCliente(Cliente cliente);

    List<Reserva> recuperarReservasPorMesa(Mesa mesa);
}
