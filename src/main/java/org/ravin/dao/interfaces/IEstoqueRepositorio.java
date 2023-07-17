package org.ravin.dao.interfaces;

import org.ravin.models.Estoque;

import java.util.Optional;

public interface IEstoqueRepositorio extends IRepositorio<Estoque>, IGeradorId {
    Optional<Estoque> recuperarPorCodigo(String codigo) ;
}
