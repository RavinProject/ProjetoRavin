package controllers;

import java.util.List;

import dao.ListasDados;
import models.Estoque;

public class EstoqueController extends Controller <Estoque> {

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
    public Estoque recuperar(int id) {
        for (Estoque estoque : pegarLista()) {
            if (estoque.getId() == id) {
                return estoque;
            }
        }
        return null;
    }

    public Estoque recuperar(String codigo) {
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
