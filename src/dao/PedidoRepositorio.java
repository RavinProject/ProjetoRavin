package dao;

import dao.interfaces.IPedidoRepositorio;
import models.Pedido;
import java.util.ArrayList;
import java.util.List;

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
    public Pedido recuperarPorId(int id) {
        return null;
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
