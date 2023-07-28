package org.ravin.dao;

import org.ravin.dao.interfaces.IClienteRepositorio;
import org.ravin.dao.interfaces.IReservaRepositorio;
import org.ravin.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ReservaRepositorio implements IReservaRepositorio {
    private final List<Reserva> listaReservas;

    public ReservaRepositorio(List<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }


    @Override
    public int geraProximoId() {
        return IReservaRepositorio.super.geraProximoId();
    }

    @Override
    public void inserir(Reserva reserva) {
        if (reserva.getId() == 0) {
            reserva.setId(geraProximoId());
        }
        listaReservas.add(reserva);
    }

    @Override
    public List<Reserva> pegarLista() {
        return listaReservas;
    }

    @Override
    public int getId(Reserva reserva) {
        return reserva.getId();
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
