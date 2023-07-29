package org.ravin.dao;

import org.ravin.dao.interfaces.IPedidoRepositorioLista;
import org.ravin.models.Pedido;

import java.util.List;
import java.util.Optional;

public class PedidoRepositorioLista implements IPedidoRepositorioLista {
    private final List<Pedido> listaPedidos;

    public PedidoRepositorioLista(List<Pedido> listaPedidos){
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
}
