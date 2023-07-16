package strategy.interfaces;

import models.Cliente;

public interface IDescontoFactory {
    IDescontoAniversariante criarDescontoAniversariante(Cliente cliente);
}
