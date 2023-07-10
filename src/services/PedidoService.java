package services;

import dao.PedidoRepositorio;
import models.Pedido;
import models.Produto;

import java.sql.Timestamp;
import java.util.Date;

public class PedidoService {
    private PedidoRepositorio pedidoRepositorio;

    public PedidoService(PedidoRepositorio pedidoRepositorio){
        this.pedidoRepositorio = pedidoRepositorio;
    }

    public void criarPedido(Produto produto, int quantidade){
        Pedido pedido = new Pedido(produto, quantidade);
        pedido.setDataHoraSolicitacao(new Timestamp(new Date().getTime()));

        this.pedidoRepositorio.inserir(pedido);
    }
}
