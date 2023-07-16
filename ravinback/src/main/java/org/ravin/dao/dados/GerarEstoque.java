package org.backend.dao.dados;

import models.Estoque;
import models.Produto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GerarEstoque {

    private final List<Produto> produtos;
    private final Random random;

    public GerarEstoque(List<Produto> produtos) {
        this.produtos = produtos;
        this.random = new Random();
    }

    public List<Estoque> generateEstoqueList() {
        List<Estoque> estoqueList = new ArrayList<>();

        for(Produto produto : this.produtos) {
            Estoque estoque = new Estoque(produto.getId(), produto, random.nextInt(100));
            estoqueList.add(estoque);
        }

        return estoqueList;
    }
}
