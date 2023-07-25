package org.ravin.strategy;

import org.ravin.models.Cliente;
import org.ravin.strategy.interfaces.IDescontoAniversariante;
import org.ravin.strategy.interfaces.IDescontoFactory;

public class DescontoFactory implements IDescontoFactory {
    @Override
    public IDescontoAniversariante criarDescontoAniversariante(Cliente cliente) {
        return new DescontoAniversariante(cliente);
    }
}
