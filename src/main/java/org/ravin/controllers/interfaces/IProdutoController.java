package org.ravin.controllers.interfaces;

import org.ravin.models.Produto;
import org.ravin.utils.exceptions.EntidadeNaoEncontradaException;


public interface IProdutoController extends IController<Produto> {

    Produto recuperarPorCodigo(String codigo) throws EntidadeNaoEncontradaException;
}
