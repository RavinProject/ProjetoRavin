package strategy;

import models.Cliente;
import strategy.interfaces.IDescontoAniversariante;

import java.util.Calendar;

public class DescontoAniversariante implements IDescontoAniversariante {
    private Cliente cliente;

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

    private boolean isAniversariante() {
        Calendar agora = Calendar.getInstance();
        Calendar dataNascimento = Calendar.getInstance();
        dataNascimento.setTime(cliente.getNascimento());

        // Compara o mês atual com o mês de nascimento
        return agora.get(Calendar.MONTH) == dataNascimento.get(Calendar.MONTH);
    }
}
