package org.ravin.controllers.interfaces;

import org.ravin.models.Estoque;
import org.ravin.utils.exceptions.EntidadeNaoEncontradaException;

public interface IEstoqueController extends IController<Estoque>{
    Estoque recuperarPorCodigo(String codigo) throws EntidadeNaoEncontradaException;
    boolean estoqueJaCadastrado(String codigo);
}
