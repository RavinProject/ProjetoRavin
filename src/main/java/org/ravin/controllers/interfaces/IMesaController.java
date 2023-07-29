package org.ravin.controllers.interfaces;

import org.ravin.models.Mesa;
import org.ravin.utils.exceptions.EntidadeNaoEncontradaException;

public interface IMesaController extends IController<Mesa> {
    Mesa recuperarPorCodigo(String codigo) throws EntidadeNaoEncontradaException;
}


