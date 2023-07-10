package controllers.interfaces;

import models.Estoque;

public interface IEstoqueController extends IController<Estoque>{
    Estoque recuperarPorCodigo(String codigo);
}
