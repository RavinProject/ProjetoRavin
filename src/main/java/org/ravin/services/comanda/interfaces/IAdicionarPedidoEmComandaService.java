package org.ravin.services.comanda.interfaces;

import org.ravin.models.Comanda;
import org.ravin.models.Pedido;

public interface IAdicionarPedidoEmComandaService {
    void adicionarPedidoEmComanda(Comanda comanda, Pedido pedido);
}
