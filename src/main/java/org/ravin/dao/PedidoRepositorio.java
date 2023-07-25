package org.ravin.dao;

import org.ravin.dao.interfaces.IPedidoRepositorio;
import org.ravin.models.Funcionario;
import org.ravin.models.Pedido;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PedidoRepositorio implements IPedidoRepositorio {
    private List<Pedido> listaPedidos;

    public PedidoRepositorio(List<Pedido> listaPedidos){
        this.listaPedidos = listaPedidos;
    }

    public void inserir(Pedido pedido){
        this.listaPedidos.add(pedido);
    }

    @Override
    public List<Pedido> pegarLista() {
        return this.listaPedidos;
    }

    @Override
    public Optional<Pedido> recuperarPorId(int id) {
        return Optional.empty();
    }

    @Override
    public void atualizar(Pedido object) {

    }

    @Override
    public void remover(Pedido object) {

    }

    @Override
    public void removerPorId(int id) {

    }

    @Override
    public int geraProximoId() {
        int maiorId = 0;
        for (Pedido pedido : pegarLista()) {
            if (pedido.getId() > maiorId) {
                maiorId = pedido.getId();
            }
        }
        return maiorId + 1;
    }
}
