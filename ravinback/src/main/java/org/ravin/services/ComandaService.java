package org.backend.services;

import dao.ComandaRepositorio;
import models.Comanda;
import utils.enums.StatusComanda;

public class ComandaService {
    private final ComandaRepositorio comandaRepository;

    public ComandaService(ComandaRepositorio comandaRepository) {
        this.comandaRepository = comandaRepository;
    }

    /**
     * Fecha a comanda com o código fornecido.
     *
     * @param codigo O codigo da comanda a ser fechada
     * @return true se bem-sucedido
     * @throws IllegalArgumentException Se a comanda com o código fornecido não for encontrada.
     */
    public boolean fecharComanda (String codigo) {
        Comanda comanda = comandaRepository.getComandaPorCodigo(codigo);
        if(comanda != null) {
            comanda.setStatusComanda(StatusComanda.FECHADA);
            comandaRepository.inserir(comanda);
            return true;
        } else {
            throw new IllegalArgumentException("Comanda com o código " + codigo + " não encontrada.");
        }
    }
}
