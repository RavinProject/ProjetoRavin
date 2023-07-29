package org.ravin.dao.interfaces;

import org.ravin.models.Cardapio;
import org.ravin.utils.interfaces.IGeradorId;

public interface ICardapioRepositorioLista extends IRepositorioLista<Cardapio>, IGeradorId<Cardapio> {

    default int getId(Cardapio cardapio){
        return cardapio.getId();
    }

}
