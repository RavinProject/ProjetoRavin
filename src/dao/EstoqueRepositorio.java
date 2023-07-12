package dao;

import dao.interfaces.IEstoqueRepositorio;
import models.Estoque;

import java.util.List;

public class EstoqueRepositorio implements IEstoqueRepositorio {

    private List<Estoque> listaEstoque;

    public EstoqueRepositorio(List<Estoque> listaEstoque) {
        this.listaEstoque = listaEstoque;
    }

    @Override
    public void inserir(Estoque estoque) {
        if (estoque.getId() == 0) {
            estoque.setId(geraProximoId());
        }
        pegarLista().add(estoque);
    }

    public int geraProximoId() {
        int maiorId = 0;
        for (Estoque estoque : pegarLista()) {
            if (estoque.getId() > maiorId) {
                maiorId = estoque.getId();
            }
        }
        return maiorId + 1;
    }

    @Override
    public List<Estoque> pegarLista() {
        return listaEstoque;
    }

    @Override
    public Estoque recuperarPorId(int id) {
        for (Estoque estoque : pegarLista()) {
            if (estoque.getId() == id) {
                return estoque;
            }
        }
        return null;
    }

    @Override
    public void atualizar(Estoque estoque) {
        for (int i = 0; i < pegarLista().size(); i++) {
            if (pegarLista().get(i).getId() == estoque.getId()) {
                pegarLista().set(i, estoque);
                break;
            }
        }
    }

    @Override
    public void remover(Estoque estoque) {
        pegarLista().removeIf(p -> p.getId() == estoque.getId());
    }

    @Override
    public void removerPorId(int id) {
        pegarLista().removeIf(p -> p.getId() == id);
    }
}
