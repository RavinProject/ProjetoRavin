/**
 * Implementação do serviço de gerenciamento de reservas.
 *
 * <p>Esta classe fornece a implementação das operações de gerenciamento de reservas, como inserir, recuperar, atualizar e remover reservas.
 * Além disso, fornece métodos para recuperar reservas por cliente ou mesa e verificar a disponibilidade da data.
 *
 */
package org.ravin.services.reserva;

import org.ravin.dao.ListasDados;
import org.ravin.dao.interfaces.IReservaRepositorioLista;
import org.ravin.models.Cliente;
import org.ravin.models.Mesa;
import org.ravin.models.Reserva;
import org.ravin.services.reserva.interfaces.IReservaService;
import org.ravin.services.reserva.interfaces.IVerificarComandaEmMesaService;
import org.ravin.utils.exceptions.MesaNaoDisponivelException;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class ReservaService implements IReservaService {
    private final IReservaRepositorioLista reservaRepository;
    private final IVerificarComandaEmMesaService verificarComandaService;

    public ReservaService (IVerificarComandaEmMesaService verificarComandaService) {
        this.reservaRepository = ListasDados.getInstance().getReservaRepositorio();
        this.verificarComandaService = verificarComandaService;
    }

    /**
     * Insere uma nova reserva.
     *
     * <p>Este método tenta inserir uma nova reserva apenas se a data estiver disponível e não houver comanda associada à mesa.
     *
     * @param reserva a reserva a ser inserida.
     * @throws MesaNaoDisponivelException se a mesa não estiver disponível para a data selecionada.
     */
    @Override
    public void inserir(Reserva reserva) throws MesaNaoDisponivelException {
        if (estaDisponivel(reserva.getData()) && !verificarComandaService.verificarComandaEmMesa(reserva.getMesa())) {
            inserir(reserva);
        } else {
            throw new MesaNaoDisponivelException("Mesa não disponível para a data selecionada.");
        }
    }

    /**
     * Recupera todas as reservas.
     *
     * @return uma lista de todas as reservas.
     */
    @Override
    public List<Reserva> recuperarTodos() {
        return reservaRepository.recuperarTodos();
    }

    /**
     * Recupera todas as reservas associadas a um cliente.
     *
     * @param cliente o cliente cujas reservas devem ser recuperadas.
     * @return uma lista de todas as reservas associadas ao cliente.
     */
    @Override
    public List<Reserva> recuperarReservasPorCliente(Cliente cliente) {
        return reservaRepository.getReservasPorCliente(cliente);
    }

    /**
     * Recupera as reservas de uma determinada mesa.
     *
     * @param mesa a mesa cujas reservas devem ser recuperadas.
     * @return uma lista das reservas da mesa.
     */
    @Override
    public List<Reserva> recuperarReservasPorMesa(Mesa mesa) {
        return reservaRepository.getReservasPorMesa(mesa);
    }

    /**
     * Recupera uma reserva por sua ID.
     *
     * @param id a ID da reserva a ser recuperada.
     * @return um {@code Optional} que pode conter a reserva se ela for encontrada.
     */
    @Override
    public Optional<Reserva> recuperarPorId(int id) {
        return reservaRepository.recuperarPorId(id);
    }

    /**
     * Atualiza uma reserva.
     *
     * @param reserva a reserva a ser atualizada.
     */
    @Override
    public void atualizar(Reserva reserva) {
        reservaRepository.atualizar(reserva);
    }

    /**
     * Remove uma reserva.
     *
     * @param reserva a reserva a ser removida.
     * @return {@code true} se a reserva foi removida com sucesso, {@code false} caso contrário.
     */
    @Override
    public boolean remover(Reserva reserva) {
        try {
            reservaRepository.remover(reserva);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Verifica se uma data está disponível para reserva.
     *
     * @param data a data a ser verificada.
     * @return {@code true} se a data estiver disponível, {@code false} caso contrário.
     */
    @Override
    public boolean estaDisponivel(Date data) {
        for (Reserva reserva : reservaRepository.recuperarTodos()) {
            if (reserva.getData().equals(data)) {
                return false;
            }
        }
        return true;
    }
}
