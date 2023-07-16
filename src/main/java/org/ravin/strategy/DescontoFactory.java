package strategy;

import models.Cliente;
import strategy.interfaces.IDescontoAniversariante;
import strategy.interfaces.IDescontoFactory;

public class DescontoFactory implements IDescontoFactory {
    @Override
    public IDescontoAniversariante criarDescontoAniversariante(Cliente cliente) {
        return new DescontoAniversariante(cliente);
    }
}
