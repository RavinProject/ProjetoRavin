package org.ravin.dao.interfaces;

import org.ravin.models.Produto;

import java.util.Optional;

public interface IProdutoRepositorio extends IRepositorio<Produto>, IGeradorId {
    Optional<Produto> recuperarPorCodigo(String codigo) ;
}
