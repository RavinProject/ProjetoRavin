package dao.interfaces;

import java.util.Optional;

import models.Produto;

public interface IProdutoRepositorio extends IRepositorio<Produto> {
    Optional<Produto> recuperarPorCodigo(String codigo) ;
}
