package org.backend.controllers.interfaces;

import models.Produto;

import java.util.NoSuchElementException;

public interface IProdutoController extends IController<Produto> {

    Produto recuperarPorCodigo(String codigo) throws NoSuchElementException;
}
