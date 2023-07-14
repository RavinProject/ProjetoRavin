package dao;

import dao.interfaces.IEstoqueRepositorio;
import models.Estoque;

import java.util.List;
import java.util.Optional;

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

    @Override
    public List<Estoque> pegarLista() {
        return listaEstoque;
    }

    @Override
    public Optional<Estoque> recuperarPorId(int id) {
        for (Estoque estoque : pegarLista()) {
            if (estoque.getId() == id) {
                return Optional.of(estoque);
            }
        }
        return Optional.empty();
    }

    @Override
    public void atualizar(Estoque estoqueAtualizado) {
        for (int i = 0; i < pegarLista().size(); i++) {
            if (pegarLista().get(i).getId() == estoqueAtualizado.getId()) {
                pegarLista().set(i, estoqueAtualizado);
                break;
            }
        }
    }

    @Override
    public void remover(Estoque estoque) {
        pegarLista().remove(estoque);
    }

    @Override
    public void removerPorId(int id) {
        pegarLista().removeIf(estoque -> estoque.getId() == id);
    }

    @Override
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
    public Optional<Estoque> recuperarPorCodigo(String codigo) {
        for (Estoque estoque : pegarLista()) {
            if (estoque.getProduto().getCodigo().equals(codigo)) {
                return Optional.of(estoque);
            }
        }
        return Optional.empty();
    }
}
