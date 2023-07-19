package org.ravin.dao;

import org.ravin.dao.interfaces.IMesaRepositorio;
import org.ravin.models.Mesa;
import org.ravin.models.Reserva;

import java.util.List;
import java.util.Optional;

public class MesaRepositorio implements IMesaRepositorio {
    private final List<Mesa> listaMesas;

    public MesaRepositorio(List<Mesa> listaMesas) {
        this.listaMesas = listaMesas;
    }

    @Override
    public void inserir(Mesa object) {

    }

    @Override
    public List<Mesa> pegarLista() {
        return null;
    }

    @Override
    public Optional<Mesa> recuperarPorId(int id) {
        return Optional.empty();
    }

    @Override
    public void atualizar(Mesa object) {

    }

    @Override
    public void remover(Mesa object) {

    }

    @Override
    public void removerPorId(int id) {

    }

    @Override
    public int geraProximoId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'geraProximoId'");
    }
}
