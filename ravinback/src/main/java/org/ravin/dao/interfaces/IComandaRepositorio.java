package org.backend.dao.interfaces;

import models.Comanda;

public interface IComandaRepositorio extends IRepositorio<Comanda> {
    Comanda getComandaPorCodigo (String codigo);
}
