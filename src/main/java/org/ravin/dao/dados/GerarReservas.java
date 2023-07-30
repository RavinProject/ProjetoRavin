package org.ravin.dao.dados;

import org.ravin.models.Cliente;
import org.ravin.models.Mesa;
import org.ravin.models.Reserva;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GerarReservas {
    public static List<Reserva> montaLista(List<Cliente> clientes, List<Mesa> mesas) {
        List<Reserva> reservas = new ArrayList<>();

        int idCounter = 1; // contador para os IDs das reservas

        for (int i = 0; i < clientes.size() && i+1 < mesas.size(); i++) {
            Reserva reserva1 =new Reserva(clientes.get(i), mesas.get(i), new Date());
            Reserva reserva2 = new Reserva(clientes.get(i), mesas.get(i+1), new Date());
            reserva1.setId(idCounter++);
            reserva2.setId(idCounter++);
            reservas.add(reserva1);
            reservas.add(reserva2);
        }

        return reservas;
    }
}