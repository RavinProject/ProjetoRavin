package org.ravin.strategy.interfaces;

import org.ravin.models.Cliente;

public interface IDescontoFactory {
    IDescontoAniversariante criarDescontoAniversariante(Cliente cliente);
}
