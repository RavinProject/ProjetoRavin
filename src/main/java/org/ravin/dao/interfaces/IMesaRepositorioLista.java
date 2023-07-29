package org.ravin.dao.interfaces;

import org.ravin.models.Mesa;
import org.ravin.utils.interfaces.IGeradorId;

import java.util.Optional;

public interface IMesaRepositorioLista extends IRepositorioLista<Mesa>, IGeradorId<Mesa> {
    Optional<Mesa> recuperarPorCodigo(String codigo);

    default int getId(Mesa mesa){
        return mesa.getId();
    }
}
