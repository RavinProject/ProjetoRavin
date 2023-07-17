package org.ravin.dao;

import org.ravin.dao.interfaces.IPedidoRepositorio;
import org.ravin.models.Pedido;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PedidoRepositorio implements IPedidoRepositorio {
    private List<Pedido> pedidos;

    public PedidoRepositorio(){
        this.pedidos = new ArrayList<>();
    }

    public void inserir(Pedido pedido){
        this.pedidos.add(pedido);
    }

    @Override
    public List<Pedido> pegarLista() {
        return this.pedidos;
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'geraProximoId'");
    }
}
