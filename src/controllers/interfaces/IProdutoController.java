package controllers.interfaces;

import java.util.NoSuchElementException;

import models.Produto;

public interface IProdutoController extends IController<Produto> {

    Produto recuperarPorCodigo(String codigo) throws NoSuchElementException;
}
