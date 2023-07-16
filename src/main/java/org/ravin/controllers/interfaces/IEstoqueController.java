package org.ravin.controllers.interfaces;

import org.ravin.models.Estoque;

import java.util.NoSuchElementException;

public interface IEstoqueController extends IController<Estoque>{
    Estoque recuperarPorCodigo(String codigo) throws NoSuchElementException;
    boolean estoqueJaCadastrado(String codigo);
}
