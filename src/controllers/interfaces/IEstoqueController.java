package controllers.interfaces;

import java.util.NoSuchElementException;

import models.Estoque;

public interface IEstoqueController extends IController<Estoque>{
    Estoque recuperarPorCodigo(String codigo) throws NoSuchElementException;
}
