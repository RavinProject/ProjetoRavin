package org.ravin.services.interfaces;

import org.ravin.models.Estoque;

import java.util.Optional;

public interface IEstoqueService extends IService<Estoque> {
    Optional<Estoque> recuperarPorCodigo(String codigo);
}
