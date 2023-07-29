package org.ravin.dao.interfaces;

import org.ravin.models.Comanda;
import org.ravin.utils.interfaces.IGeradorId;

import java.util.Optional;

public interface IComandaRepositorioLista extends IRepositorioLista<Comanda>, IGeradorId<Comanda> {
    Optional<Comanda> recuperarComandaPorCodigo(String codigo);

    default int getId(Comanda comanda){
        return comanda.getId();
    }
}
