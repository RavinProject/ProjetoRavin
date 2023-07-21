package org.ravin.services;

import org.ravin.dao.ListasDados;
import org.ravin.dao.PedidoRepositorio;
import org.ravin.dao.interfaces.IPedidoRepositorio;
import org.ravin.models.Pedido;
import org.ravin.models.Produto;

import java.sql.Timestamp;
import java.util.Date;

public class PedidoService {

    // Injeção de dependência parcial - lista por Singleton
    private IPedidoRepositorio pedidoRepositorio;
    public PedidoService(){ this.pedidoRepositorio = ListasDados.getInstance().gerPedidoRepositorio(); }

    public void criarPedido(Produto produto, int quantidade){
        Pedido pedido = new Pedido(produto, quantidade);
        pedido.setDataHoraSolicitacao(new Timestamp(new Date().getTime()));

        this.pedidoRepositorio.inserir(pedido);
    }
}
