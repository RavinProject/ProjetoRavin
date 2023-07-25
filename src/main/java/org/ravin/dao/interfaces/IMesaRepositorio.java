package org.ravin.dao.interfaces;

import org.ravin.models.Mesa;
import org.ravin.utils.interfaces.IGeradorId;

public interface IMesaRepositorio extends IRepositorio<Mesa>, IGeradorId<Mesa> {
    default int getId(Mesa mesa){
        return mesa.getId();
    }
}
