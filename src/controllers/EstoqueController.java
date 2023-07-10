package controllers;

import java.util.List;

import controllers.interfaces.IEstoqueController;
import dao.ListasDados;
import models.Estoque;

public class EstoqueController implements IEstoqueController {

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
    public boolean remover(Estoque estoque) {
        return pegarLista().removeIf(p -> p.getId() == estoque.getId());
    }

    @Override
    public void inserir(Estoque estoque) {
        if (estoque.getId() == 0) {
            estoque.setId(geraProximoId());
        }
        pegarLista().add(estoque);
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
    public Estoque recuperarPorCodigo(String codigo) {
        for(Estoque estoque : pegarLista()){
            if(estoque.getProduto().getCodigo().equals(codigo)){
                return estoque;
            }
        }
        return null;
    }

    @Override
    public List<Estoque> pegarLista() {
        return ListasDados.getInstance().getListaEstoque();
    }

    public int geraProximoId() {
        return pegarLista().size() + 1;
    }
    
}
