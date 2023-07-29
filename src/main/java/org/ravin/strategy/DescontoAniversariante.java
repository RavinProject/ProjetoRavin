package org.ravin.strategy;

import org.ravin.models.Cliente;
import org.ravin.strategy.interfaces.IDescontoAniversariante;

import java.util.Calendar;

public class DescontoAniversariante implements IDescontoAniversariante {
    private final Cliente cliente;

    public DescontoAniversariante(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public double aplicarDesconto(double valorTotal) {
        if (isAniversariante()) {
            return valorTotal * 0.9;
        } else {
            return valorTotal;
        }
    }

    protected Calendar getCurrentDate() {
        return Calendar.getInstance();
    }

    private boolean isAniversariante() {
        Calendar agora = Calendar.getInstance();
        Calendar dataNascimento = Calendar.getInstance();

        if (cliente != null && cliente.getNascimento() != null) {
            dataNascimento.setTime(cliente.getNascimento());

            // Compara o mês atual com o mês de nascimento
            return agora.get(Calendar.MONTH) == dataNascimento.get(Calendar.MONTH);
        }
        return false;
    }
}
