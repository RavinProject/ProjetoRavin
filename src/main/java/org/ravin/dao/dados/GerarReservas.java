package org.ravin.dao.dados;

import org.ravin.models.Cliente;
import org.ravin.models.Mesa;
import org.ravin.models.Reserva;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class GerarReservas {
    public static List<Reserva> montaLista(List<Cliente> clientes, List<Mesa> mesas) {
        List<Reserva> reservas = new ArrayList<>();

        for (int i = 0; i < clientes.size() && i < mesas.size(); i++) {
            Reserva reserva = new Reserva(clientes.get(i), mesas.get(i), new Date());
            reservas.add(reserva);
        }

        return reservas;
    }
}