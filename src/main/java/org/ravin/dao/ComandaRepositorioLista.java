package org.ravin.dao;

import org.ravin.dao.interfaces.IComandaRepositorioLista;
import org.ravin.models.Comanda;
import org.ravin.models.Mesa;
import org.ravin.utils.enums.StatusComanda;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class ComandaRepositorioLista implements IComandaRepositorioLista {
    private final List<Comanda> listaComanda;

    public ComandaRepositorioLista(List<Comanda> listaComanda) {

        this.listaComanda = listaComanda;
    }

    @Override
    public void inserir(Comanda comanda) {

        listaComanda.add(comanda);
    }

    @Override
    public List<Comanda> recuperarTodos() {
        return listaComanda;
    }

    @Override
    public Optional<Comanda> recuperarPorId(int id) {
        return Optional.empty();
    }

    @Override
    public void atualizar(Comanda comandaAtualizada) {
        for (int i = 0; i < listaComanda.size(); i++) {
            if (listaComanda.get(i).getId() == comandaAtualizada.getId()) {
                listaComanda.set(i, comandaAtualizada);
                break;
            }
        }
    }

    @Override
    public void remover(Comanda comanda) {

    }

    @Override
    public void removerPorId(int id) {

    }

    @Override
    public Optional<Comanda> recuperarComandaPorCodigo(String codigo) {
        for (Comanda comanda : listaComanda) {
            if (Objects.equals(comanda.getCodigo(), codigo)) {
                return Optional.of(comanda);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Comanda> recuperarListaPorMesaEStatus(Mesa mesa, StatusComanda statusComanda) {
        return listaComanda.stream().
                filter(c -> c.getMesa().equals(mesa) && c.getStatusComanda().equals(statusComanda)).
                collect(Collectors.toList());
    }

    @Override
    public int getId(Comanda comanda) {
        return IComandaRepositorioLista.super.getId(comanda);
    }

}
