package org.ravin.dao.interfaces;

import org.ravin.models.Comanda;
import org.ravin.models.Mesa;
import org.ravin.utils.enums.StatusComanda;
import org.ravin.utils.interfaces.IGeradorId;

import java.util.List;
import java.util.Optional;

public interface IComandaRepositorioLista extends IRepositorioLista<Comanda>, IGeradorId<Comanda> {
    Optional<Comanda> recuperarComandaPorCodigo(String codigo);

    List<Comanda> recuperarListaPorMesaEStatus(Mesa mesa, StatusComanda statusComanda);

    default int getId(Comanda comanda){
        return comanda.getId();
    }
}
