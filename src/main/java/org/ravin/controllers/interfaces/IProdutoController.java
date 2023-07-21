package org.ravin.controllers.interfaces;

import org.ravin.models.Produto;
import org.ravin.utils.exceptions.EntidadeNaoEncontradaException;

import java.util.NoSuchElementException;

public interface IProdutoController extends IController<Produto> {
    Produto recuperarPorCodigo(String codigo) throws EntidadeNaoEncontradaException;
}
