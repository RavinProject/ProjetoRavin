package org.ravin.dao.interfaces;

import org.ravin.models.Comanda;

public interface IComandaRepositorio extends IRepositorio<Comanda>, IGeradorId {
    Comanda getComandaPorCodigo (String codigo);
}
