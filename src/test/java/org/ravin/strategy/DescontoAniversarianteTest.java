package org.ravin.strategy;

import org.junit.jupiter.api.Test;
import org.ravin.models.Cliente;
import org.ravin.strategy.interfaces.IDescontoAniversariante;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

public class DescontoAniversarianteTest {
    @Test
    public void testAplicarDesconto() {
        int currentMonth = Calendar.getInstance().get(Calendar.MONTH);
        int differentBirthMonth = (currentMonth + 1) % 12;  // Isso garante que birthMonth não seja o mês atual
        int currentBirthMonth = currentMonth;

        // Teste quando o mês de aniversário do cliente não é o mês atual
        Cliente cliente = createClienteWithBirthMonth(differentBirthMonth);
        IDescontoAniversariante desconto = new TestableDescontoAniversariante(cliente, currentMonth);
        assertEquals(100.0, desconto.aplicarDesconto(100.0), "O desconto não deve ser aplicado se não for o mês de aniversário do cliente");

        // Teste quando o mês de aniversário do cliente é o mês atual
        cliente = createClienteWithBirthMonth(currentBirthMonth);
        desconto = new TestableDescontoAniversariante(cliente, currentMonth);
        assertEquals(90.0, desconto.aplicarDesconto(100.0), "O desconto deve ser aplicado se for o mês de aniversário do cliente");
    }

    // Subclasse de teste que permite controlar o mês atual
    private static class TestableDescontoAniversariante extends DescontoAniversariante {
        private final int currentMonth;

        TestableDescontoAniversariante(Cliente cliente, int currentMonth) {
            super(cliente);
            this.currentMonth = currentMonth;
        }

        @Override
        protected Calendar getCurrentDate() {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.MONTH, currentMonth);
            return calendar;
        }
    }

    private Cliente createClienteWithBirthMonth(int birthMonth) {
        Cliente cliente = new Cliente();
        cliente.setNascimento(new GregorianCalendar(1990, birthMonth, 1).getTime());
        return cliente;
    }
}