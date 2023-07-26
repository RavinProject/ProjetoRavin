package org.ravin.dao;

import org.ravin.dao.interfaces.IReservaRepositorio;
import org.ravin.models.Comanda;
import org.ravin.models.Produto;
import org.ravin.models.Reserva;

import java.util.List;
import java.util.Optional;

public class ReservaRepositorio implements IReservaRepositorio {
    private final List<Reserva> listaReservas;

    public ReservaRepositorio(List<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }


    @Override
    public int geraProximoId() {
        return 0;
    }

    @Override
    public void inserir(Reserva reserva) {

    }

    @Override
    public List<Reserva> pegarLista() {
        return null;
    }

    @Override
    public int getId(Reserva reserva) {
        return reserva.getId();
    }

    @Override
    public Optional<Reserva> recuperarPorId(int id) {
        return Optional.empty();
    }

    @Override
    public void atualizar(Reserva reserva) {

    }

    @Override
    public void remover(Reserva reserva) {

    }

    @Override
    public void removerPorId(int id) {

    }
}
