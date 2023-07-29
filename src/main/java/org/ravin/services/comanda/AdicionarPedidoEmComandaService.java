package org.ravin.services.comanda;

import org.ravin.models.Comanda;
import org.ravin.models.Pedido;
import org.ravin.services.comanda.interfaces.IAdicionarPedidoEmComandaService;

public class AdicionarPedidoEmComandaService implements IAdicionarPedidoEmComandaService {

    /**
     * Adiciona um Pedido à lista de Pedidos dentro de Comanda
     * Ao final, atualiza também o valor total bruto
     *
     * @param comanda a ser alterada
     * @param pedido a ser inserido
     */
    public void adicionarPedidoEmComanda(Comanda comanda, Pedido pedido){
        comanda.getPedidos().add(pedido);
        double valorBrutoAnterior = comanda.getTotalBruto();
        double valorProduto = pedido.getProduto().getPrecoVenda();
        double novoValorBruto = valorBrutoAnterior + valorProduto;
        comanda.setTotalBruto(novoValorBruto);
    }
}
