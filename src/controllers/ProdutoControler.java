package controllers;

import java.util.List;

import dao.ListasDados;
import models.Produto;

public class ProdutoControler extends Controller <Produto> {

    @Override
    public void atualizar(Produto produto) {
        for (int i = 0; i < pegarLista().size(); i++) {
            if (pegarLista().get(i).getId() == produto.getId()) {
                pegarLista().set(i, produto);
                break;
            }
        }
    }

    @Override
    public boolean remover(Produto produto) {
        return pegarLista().removeIf(p -> p.getId() == produto.getId());
    }

    @Override
    public void inserir(Produto produto) {
        if (produto.getId() == 0) {
            produto.setId(geraProximoId());
        }
        pegarLista().add(produto);
    }

    @Override
    public Produto recuperar(int id) {
        for (Produto produto : pegarLista()) {
            if (produto.getId() == id) {
                return produto;
            }
        }
        return null;
    }

    public Produto recuperar(String codigo) {
        for(Produto produto : pegarLista()){
            if(produto.getCodigo().equals(codigo)){
                return produto;
            }
        }
        return null;
    }

    @Override
    public List<Produto> pegarLista() {
        return ListasDados.getInstance().getListaProduto();
    }
    
    public int geraProximoId() {
        return pegarLista().size() + 1;
    }
}
