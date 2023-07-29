package org.ravin.services.comanda.interfaces;

import org.ravin.models.Pedido;

import java.util.List;

public interface ICalcularTotalComanda {
    static double calcularTotalBruto(List<Pedido> pedidos) {
        return pedidos.stream().mapToDouble(Pedido::getTotal).sum();
    }
}
