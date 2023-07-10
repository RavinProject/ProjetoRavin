package controllers.interfaces;

import models.Produto;

public interface IProdutoController extends IController<Produto> {

    Produto recuperarPorCodigo(String codigo);
}
