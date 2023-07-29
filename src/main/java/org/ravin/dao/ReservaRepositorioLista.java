package org.ravin.dao;

import org.ravin.dao.interfaces.IReservaRepositorioLista;
import org.ravin.models.Cliente;
import org.ravin.models.Mesa;
import org.ravin.models.Reserva;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ReservaRepositorioLista implements IReservaRepositorioLista {
    private final List<Reserva> listaReservas;

    public ReservaRepositorioLista(List<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }

    @Override
    public void inserir(Reserva reserva) {
        if (reserva.getId() == 0) {
            reserva.setId(geraProximoId(listaReservas));
        }
        listaReservas.add(reserva);
    }

    @Override
    public List<Reserva> pegarLista() {
        return listaReservas;
    }

    @Override
    public Optional<Reserva> recuperarPorId(int id) {
        for (Reserva reserva : listaReservas) {
            if (reserva.getId() == id) {
                return Optional.of(reserva);
            }
        }
        return Optional.empty();
    }

    @Override
    public void atualizar(Reserva reservaAtualizada) {
        for (int i = 0; i < listaReservas.size(); i++) {
            if (listaReservas.get(i).getId() == reservaAtualizada.getId()) {
                listaReservas.set(i, reservaAtualizada);
                break;
            }
        }
    }

    @Override
    public void remover(Reserva reserva) {
        listaReservas.remove(reserva);
    }

    @Override
    public void removerPorId(int id) {
        listaReservas.removeIf(reserva -> reserva.getId() == id);
    }

    @Override
    public List<Reserva> getReservasPorCliente(Cliente cliente) {
        return listaReservas.stream()
                .filter(reserva -> reserva.getCliente().equals(cliente))
                .collect(Collectors.toList());
    }

    @Override
    public List<Reserva> getReservasPorMesa(Mesa mesa) {
        return listaReservas.stream()
                .filter(reserva -> reserva.getMesa().equals(mesa))
                .collect(Collectors.toList());
    }
}
