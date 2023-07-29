package org.ravin.services.comanda.interfaces;

import org.ravin.models.Comanda;

public interface IRemoverPedidoEmComandaService {
    public boolean removerPedidoEmComanda(Comanda comanda, String codigo);
}
