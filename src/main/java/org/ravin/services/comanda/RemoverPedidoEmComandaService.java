/**
 * Serviço para remover pedidos de uma comanda.
 *
 * <p>Este serviço é responsável por remover um pedido de uma comanda, identificado por seu código. Após
 * a remoção do pedido, o valor total bruto da comanda é recalculado e atualizado.
 *
 * <p>Implementa duas interfaces: {@code IRemoverPedidoEmComandaService} que define a funcionalidade básica de
 * remover um pedido de uma comanda, e {@code ICalcularTotalComanda} que define a funcionalidade de calcular
 * o total bruto de uma comanda.
 *
 * @see IRemoverPedidoEmComandaService
 * @see ICalcularTotalComanda
 */

package org.ravin.services.comanda;

import org.ravin.models.Comanda;
import org.ravin.models.Pedido;
import org.ravin.services.comanda.interfaces.ICalcularTotalComanda;
import org.ravin.services.comanda.interfaces.IRemoverPedidoEmComandaService;


public class RemoverPedidoEmComandaService implements IRemoverPedidoEmComandaService, ICalcularTotalComanda {

    /**
     * Remove um pedido de uma comanda e recalcula o valor total bruto.
     *
     * <p>Este método busca um pedido na comanda pelo seu código e, se encontrado, remove o pedido da lista de
     * pedidos da comanda. Em seguida, recalcula o valor total bruto da comanda e atualiza este valor na comanda.
     *
     * <p>Se o pedido não for encontrado na comanda, o método retorna {@code false}. Caso contrário, retorna {@code true}.
     *
     * @param comanda a comanda da qual o pedido será removido
     * @param codigo o código do pedido a ser removido
     * @return {@code true} se o pedido foi removido com sucesso, {@code false} caso contrário
     */
    public boolean removerPedidoEmComanda(Comanda comanda, String codigo){
        Pedido pedido = comanda.getPedidos().stream()
                .filter(p -> p.getCodigo().equals(codigo))
                .findFirst()
                .orElse(null);
        if(pedido == null){
            return false;
        } else {
            comanda.getPedidos().remove(pedido);
            double totalBruto = ICalcularTotalComanda.calcularTotalBruto(comanda.getPedidos());
            comanda.setTotalBruto(totalBruto);
            return true;
        }
    }
}
