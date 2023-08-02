package org.ravin.services;

import org.ravin.dao.ListasDados;
import org.ravin.dao.interfaces.IReservaRepositorioLista;
import org.ravin.models.Cliente;
import org.ravin.models.Mesa;
import org.ravin.models.Reserva;
import org.ravin.services.interfaces.IReservaService;
import org.ravin.utils.exceptions.MesaNaoDisponivelException;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class ReservaService implements IReservaService {
    private final IReservaRepositorioLista reservaRepository;
    public ReservaService () { this.reservaRepository = ListasDados.getInstance().getReservaRepositorio(); }

    @Override
    public void reservar(Cliente cliente, Mesa mesa, Date data) throws MesaNaoDisponivelException {
        if (estaDisponivel(data)) { // Verifique se a mesa está disponível no momento desejado
            Reserva reserva = new Reserva(cliente, mesa, data); // Crie uma nova reserva
            reservaRepository.inserir(reserva); // Insira a reserva no repositório
        } else {
            throw new MesaNaoDisponivelException("Mesa não disponível para a data selecionada.");
        }
    }

    @Override
    public boolean estaDisponivel(Date data) {
        for (Reserva reserva : reservaRepository.recuperarTodos()) {
            if (reserva.getData().equals(data)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void inserir(Reserva reserva) {
        reservaRepository.inserir(reserva);
    }

    @Override
    public Optional<Reserva> recuperarPorId(int id) {
        return reservaRepository.recuperarPorId(id);
    }

    @Override
    public List<Reserva> recuperarTodos() {
        return reservaRepository.recuperarTodos();
    }

    @Override
    public void atualizar(Reserva reserva) {
        reservaRepository.atualizar(reserva);
    }

    @Override
    public boolean remover(Reserva reserva) {
        try {
            reservaRepository.remover(reserva);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
