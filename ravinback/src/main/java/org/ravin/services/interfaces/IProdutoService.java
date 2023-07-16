package org.ravin.services.interfaces;

import org.ravin.models.Estoque;
import org.ravin.models.Produto;

import java.util.Optional;

public interface IProdutoService extends IService<Produto> {
    Optional<Produto> recuperarPorCodigo(String codigo);
}
