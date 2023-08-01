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
import org.ravin.utils.enums.StatusMesa;
import org.ravin.utils.exceptions.ComandaEmMesaException;
import org.ravin.utils.exceptions.DataIndisponivelException;
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
     * <p>Este método tenta inserir uma nova reserva apenas se a data e a mesa estiverem disponíveis e não houver comanda associada à mesa.
     * Além disso, verifica se os parâmetros da reserva são válidos (não nulos).
     *
     * @param reserva a reserva a ser inserida. Não pode ser nula e deve conter uma data e mesa válidas.
     * @throws IllegalArgumentException se a reserva, a data ou a mesa forem nulas.
     * @throws MesaNaoDisponivelException se a mesa já estiver ocupada.
     * @throws DataIndisponivelException se a data selecionada não estiver disponível para a mesa especificada.
     * @throws ComandaEmMesaException se existir uma comanda associada à mesa selecionada.
     */
    public void inserir(Reserva reserva) throws MesaNaoDisponivelException, DataIndisponivelException, ComandaEmMesaException {
        if (reserva == null || reserva.getData() == null || reserva.getMesa() == null) {
            throw new IllegalArgumentException("Reserva, data ou mesa não podem ser nulos.");
        }

        if (reserva.getMesa().getStatusMesa() != StatusMesa.LIVRE) {
            throw new MesaNaoDisponivelException("A mesa já está ocupada.");
        }

        if (!estaDisponivel(reserva.getData(), reserva.getMesa())) {
            throw new DataIndisponivelException("A data selecionada não está disponível.");
        }

        if (verificarComandaService.verificarComandasAbertasEmMesa(reserva.getMesa())) {
            throw new ComandaEmMesaException("Existe uma comanda associada à mesa selecionada.");
        }

        reservaRepository.inserir(reserva);
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
    public boolean estaDisponivel(Date data, Mesa mesa) {
        for (Reserva reserva : reservaRepository.recuperarTodos()) {
            if (reserva.getData().equals(data) && reserva.getMesa().equals(mesa)) {
                return false;
            }
        }
        return true;
    }
}
