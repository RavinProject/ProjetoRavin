package org.ravin.dao;

import org.ravin.dao.interfaces.ICardapioRepositorio;
import org.ravin.models.Cardapio;

import java.util.List;
import java.util.Optional;

public class CardapioRepositorio implements ICardapioRepositorio {
    @Override
    public void inserir(Cardapio object) {

    }

    @Override
    public List<Cardapio> pegarLista() {
        return null;
    }

    @Override
    public Optional<Cardapio> recuperarPorId(int id) {
        return Optional.empty();
    }

    @Override
    public void atualizar(Cardapio object) {

    }

    @Override
    public void remover(Cardapio object) {

    }

    @Override
    public void removerPorId(int id) {
    }
}
