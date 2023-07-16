package org.backend.dao.interfaces;

import models.Estoque;

import java.util.Optional;

public interface IEstoqueRepositorio extends IRepositorio<Estoque> {
    Optional<Estoque> recuperarPorCodigo(String codigo) ;
}
