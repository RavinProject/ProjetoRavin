package dao;

import dao.interfaces.IProdutoRepositorio;
import models.Produto;

import java.util.List;

public class ProdutoRepositorio implements IProdutoRepositorio {
    private List<Produto> listaProdutos;

    public ProdutoRepositorio(List<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    @Override
    public void inserir(Produto produto) {
        if (produto.getId() == 0) {
            produto.setId(geraProximoId());
        }
        pegarLista().add(produto);
    }

    public int geraProximoId() {
        int maiorId = 0;
        for (Produto produto : pegarLista()) {
            if (produto.getId() > maiorId) {
                maiorId = produto.getId();
            }
        }
        return maiorId + 1;
    }

    @Override
    public List<Produto> pegarLista() {
        return listaProdutos;
    }

    @Override
    public Produto recuperarPorId(int id) {
        for (Produto produto : pegarLista()) {
            if (produto.getId() == id) {
                return produto;
            }
        }
        return null;
    }

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
    public void remover(Produto produto) {
        pegarLista().removeIf(p -> p.getId() == produto.getId());
    }

    @Override
    public void removerPorId(int id) {
        pegarLista().removeIf(p -> p.getId() == id);
    }
}
