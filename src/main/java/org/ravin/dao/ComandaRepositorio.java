package org.ravin.dao;

import org.ravin.dao.interfaces.IComandaRepositorio;
import org.ravin.models.Comanda;
import org.ravin.models.Estoque;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ComandaRepositorio implements IComandaRepositorio {
    private final List<Comanda> listaComanda;

    public ComandaRepositorio(List<Comanda> listaComanda) {

        this.listaComanda = listaComanda;
    }

    @Override
    public void inserir(Comanda comanda) {

        pegarLista().add(comanda); // Adiciona a cliente na lista
    }

    @Override
    public List<Comanda> pegarLista() {
        return listaComanda;
    }

    @Override
    public Optional<Comanda> recuperarPorId(int id) {
        return Optional.empty();
    }

    @Override
    public void atualizar(Comanda comandaAtualizada) {
        for (int i = 0; i < pegarLista().size(); i++) {
            if (pegarLista().get(i).getId() == comandaAtualizada.getId()) {
                pegarLista().set(i, comandaAtualizada);
                break;
            }
        }
    }

    @Override
    public void remover(Comanda object) {

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
    public int geraProximoId() {
        int maiorId = 0;
        for (Comanda comanda : pegarLista()) {
            if (comanda.getId() > maiorId) {
                maiorId = comanda.getId();
            }
        }
        return maiorId + 1;
    }
}
