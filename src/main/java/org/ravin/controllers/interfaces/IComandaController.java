<<<<<<< HEAD:src/main/java/org/ravin/controllers/interfaces/IComandaController.java
package org.ravin.controllers.interfaces;

import org.ravin.models.Comanda;
import org.ravin.utils.exceptions.EntidadeNaoEncontradaException;
=======
package controllers.interfaces;

import models.Comanda;
import utils.exceptions.EntidadeNaoEncontradaException;
>>>>>>> a74de39271b06fb8dbd409afb4d90f0c68de08e9:src/controllers/interfaces/IComandaController.java

public interface IComandaController extends IController<Comanda> {
    void processarComanda(Comanda comanda) throws EntidadeNaoEncontradaException;
}
