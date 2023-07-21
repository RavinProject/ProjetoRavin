package org.ravin.controllers;

import org.ravin.controllers.interfaces.IMesaController;
import org.ravin.models.Mesa;
import org.ravin.services.comanda.interfaces.IPagarComandaService;
import org.ravin.services.interfaces.IMesaService;

import java.util.List;

public class MesaController implements IMesaController {

    // Injeção de dependência
    private final IMesaService mesaService;
    public MesaController(IMesaService mesaService) {
        this.mesaService = mesaService;
    }
    @Override
    public void inserir(Mesa objeto) {

    }

    @Override
    public Mesa recuperarPorId(int id) {
        return null;
    }

    @Override
    public List<Mesa> pegarLista() {
        return null;
    }

    @Override
    public void atualizar(Mesa objeto) {

    }

    @Override
    public boolean remover(Mesa objeto) {
        return false;
    }
}
