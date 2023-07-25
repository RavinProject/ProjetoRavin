package org.ravin.dao.interfaces;

import org.ravin.models.Pedido;
import org.ravin.utils.interfaces.IGeradorId;

public interface IPedidoRepositorio extends IRepositorio<Pedido>, IGeradorId<Pedido> {
    default int getId(Pedido pedido){
        return pedido.getId();
    }
}
