package org.ravin.dao.interfaces;

import org.ravin.models.Pedido;
import org.ravin.utils.interfaces.IGeradorId;

public interface IPedidoRepositorioLista extends IRepositorioLista<Pedido>, IGeradorId<Pedido> {
    default int getId(Pedido pedido){
        return pedido.getId();
    }
}
