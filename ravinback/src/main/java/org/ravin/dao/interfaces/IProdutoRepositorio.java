package org.backend.dao.interfaces;

import models.Produto;

import java.util.Optional;

public interface IProdutoRepositorio extends IRepositorio<Produto> {
    Optional<Produto> recuperarPorCodigo(String codigo) ;
}
