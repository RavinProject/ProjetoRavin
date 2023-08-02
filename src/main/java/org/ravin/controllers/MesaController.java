package org.ravin.controllers;

import org.ravin.controllers.interfaces.IMesaController;
import org.ravin.models.Mesa;
import org.ravin.services.interfaces.IMesaService;
import org.ravin.utils.exceptions.EntidadeNaoEncontradaException;

import java.util.List;
import java.util.Optional;

public class MesaController implements IMesaController {
    private final IMesaService mesaService;
    public MesaController(IMesaService mesaService) {
        this.mesaService = mesaService;
    }
    @Override
    public void inserir(Mesa mesa) {
        mesaService.inserir(mesa);
    }

    @Override
    public Mesa recuperarPorId(int id) throws EntidadeNaoEncontradaException {
        Optional<Mesa> oMesa = mesaService.recuperarPorId(id);
        if (oMesa.isPresent()) {
            return oMesa.get();
        } else {
            throw new EntidadeNaoEncontradaException("Mesa não encontrada para o ID: " + id);
        }
    }

    @Override
    public Mesa recuperarPorCodigo(String codigo) throws EntidadeNaoEncontradaException {
        Optional<Mesa> oMesa = mesaService.recuperarPorCodigo(codigo);
        if (oMesa.isPresent()) {
            return oMesa.get();
        } else {
            throw new EntidadeNaoEncontradaException("Mesa não encontrada para o Codigo: " + codigo);
        }
    }

    @Override
    public List<Mesa> recuperarTodos() {
        return mesaService.recuperarTodos();
    }

    @Override
    public void atualizar(Mesa objeto) {

    }

    @Override
    public boolean remover(Mesa mesa) {
        try {
            mesaService.remover(mesa);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
