package org.ravin.services;

import org.ravin.dao.ListasDados;
import org.ravin.dao.interfaces.IReservaRepositorio;
import org.ravin.models.Cliente;
import org.ravin.models.Mesa;
import org.ravin.models.Reserva;
import org.ravin.services.interfaces.IReservaService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class ReservaService implements IReservaService {

    // Injeção de dependência parcial - lista por Singleton
    private final IReservaRepositorio reservaRepository;
    public ReservaService () { this.reservaRepository = ListasDados.getInstance().getReservaRepositorio(); }

    @Override
    public void reservarMesa(Cliente cliente, Mesa mesa, Date data) {
        Reserva reserva = cliente.reservarMesa(mesa, data);
        reservaRepository.inserir(reserva);
    }

    @Override
    public void inserir(Reserva objeto) {  }

    @Override
    public Optional<Reserva> recuperarPorId(int id) {
        return Optional.empty();
    }

    @Override
    public List<Reserva> pegarLista() {
        return null;
    }

    @Override
    public void atualizar(Reserva objeto) {

    }

    @Override
    public boolean remover(Reserva objeto) {
        return false;
    }
}
