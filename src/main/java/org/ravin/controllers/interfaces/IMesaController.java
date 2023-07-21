package org.ravin.controllers.interfaces;

import org.ravin.models.Mesa;
import org.ravin.utils.exceptions.EntidadeNaoEncontradaException;

import java.util.NoSuchElementException;

public interface IMesaController extends IController<Mesa> {
    Mesa recuperarPorCodigo(String codigo) throws EntidadeNaoEncontradaException;
}


