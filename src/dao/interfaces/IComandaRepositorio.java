package dao.interfaces;

import models.Comanda;

import java.util.Optional;

public interface IComandaRepositorio extends IRepositorio<Comanda> {
    Optional<Comanda> getComandaPorCodigo (String codigo);
}
