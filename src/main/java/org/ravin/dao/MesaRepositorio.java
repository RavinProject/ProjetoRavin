package org.ravin.dao;

import org.ravin.dao.interfaces.IMesaRepositorio;
import org.ravin.models.Funcionario;
import org.ravin.models.Mesa;

import java.util.List;
import java.util.Optional;

public class MesaRepositorio implements IMesaRepositorio {
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
        int maiorId = 0;
        for (Mesa mesa : pegarLista()) {
            if (mesa.getId() > maiorId) {
                maiorId = mesa.getId();
            }
        }
        return maiorId + 1;
    }
}
