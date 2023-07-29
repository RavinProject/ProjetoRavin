package org.ravin.services.comanda;

import org.ravin.models.Comanda;
import org.ravin.models.Pedido;
import org.ravin.services.comanda.interfaces.IRemoverPedidoEmComandaService;
import org.ravin.services.comanda.interfaces.ICalcularTotalComanda;

public class RemoverPedidoEmComandaService implements IRemoverPedidoEmComandaService, ICalcularTotalComanda {
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
