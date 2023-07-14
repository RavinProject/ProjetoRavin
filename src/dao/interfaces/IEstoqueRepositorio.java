package dao.interfaces;

import java.util.Optional;

import models.Estoque;

public interface IEstoqueRepositorio extends IRepositorio<Estoque> {
    Optional<Estoque> recuperarPorCodigo(String codigo) ;
}
