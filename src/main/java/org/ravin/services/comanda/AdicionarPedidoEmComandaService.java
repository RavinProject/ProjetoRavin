/**
 * Serviço para adicionar pedidos em comandas.
 *
 * <p>Este serviço é responsável por adicionar pedidos à lista de pedidos de uma comanda.
 * Além disso, este serviço atualiza o valor total bruto da comanda após a adição do novo pedido.
 *
 * <p>Este é um passo importante na gestão de pedidos de comanda, permitindo adicionar
 * novos pedidos a comanda em tempo real e manter o total de pedidos atualizado.
 *
 * @see IAdicionarPedidoEmComandaService
 */

package org.ravin.services.comanda;

import org.ravin.models.Comanda;
import org.ravin.models.Pedido;
import org.ravin.services.comanda.interfaces.IAdicionarPedidoEmComandaService;

public class AdicionarPedidoEmComandaService implements IAdicionarPedidoEmComandaService {

    /**
     * Adiciona um pedido à lista de pedidos de uma comanda e atualiza o valor total bruto.
     *
     * <p>O novo valor total bruto é calculado somando o valor bruto anterior ao preço de venda do produto
     * no pedido que está sendo adicionado.
     *
     * @param comanda a comanda na qual o pedido será inserido
     * @param pedido o pedido a ser inserido na comanda
     */
    public void adicionarPedidoEmComanda(Comanda comanda, Pedido pedido){
        comanda.getPedidos().add(pedido);
        double valorBrutoAnterior = comanda.getTotalBruto();
        double valorProduto = pedido.getProduto().getPrecoVenda();
        double novoValorBruto = valorBrutoAnterior + valorProduto;
        comanda.setTotalBruto(novoValorBruto);
    }
}
