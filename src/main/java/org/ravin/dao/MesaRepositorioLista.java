package org.ravin.dao;

import org.ravin.dao.interfaces.IMesaRepositorioLista;
import org.ravin.models.Mesa;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class MesaRepositorioLista implements IMesaRepositorioLista {
    private final List<Mesa> listaMesas;

    public MesaRepositorioLista(List<Mesa> listaMesas) {
        this.listaMesas = listaMesas;
    }

    @Override
    public void inserir(Mesa mesa) {
        if (mesa.getId() == 0) {
            mesa.setId(geraProximoId(listaMesas));
        }
        listaMesas.add(mesa);
    }

    @Override
    public List<Mesa> recuperarTodos() {
        return listaMesas;
    }

    @Override
    public Optional<Mesa> recuperarPorId(int id) {
        for (Mesa mesa : listaMesas) {
            if (mesa.getId() == id) {
                return Optional.of(mesa);
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<Mesa> recuperarPorCodigo(String codigo) {
        Optional<Mesa> result = Optional.empty();
        for (Mesa mesa : listaMesas) {
            if (Objects.equals(mesa.getCodigo(), codigo)) {
                result = Optional.of(mesa);
                break;
            }
        }
        return result;
    }

    @Override
    public void atualizar(Mesa mesa) {
        for (int i = 0; i < listaMesas.size(); i++) {
            if (listaMesas.get(i).getId() == mesa.getId()) {
                listaMesas.set(i, mesa);
                break;
            }
        }
    }

    @Override
    public void remover(Mesa mesa) {
        listaMesas.removeIf(m -> m.getId() == mesa.getId());
    }

    @Override
    public void removerPorId(int id) {
        listaMesas.removeIf(m -> m.getId() == id);
    }

    @Override
    public int geraProximoId(List<Mesa> lista) {
        return IMesaRepositorioLista.super.geraProximoId(lista);
    }

    @Override
    public int getId(Mesa mesa) {
        return mesa.getId();
    }
}

