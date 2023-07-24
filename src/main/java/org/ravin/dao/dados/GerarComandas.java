package org.ravin.dao.dados;

import org.ravin.models.Cliente;
import org.ravin.models.Comanda;
import org.ravin.models.Pedido;
import org.ravin.utils.enums.StatusComanda;

import java.util.ArrayList;
import java.util.List;

public class GerarComandas {

    private static final String COMANDA_CODIGO = "COMANDA";

    public static List<Comanda> montaLista(List<Cliente> clientesList, List<Pedido> pedidosList) {
        List<Comanda> comandas = new ArrayList<>();

        // Comanda 1
        Comanda comanda1 = new Comanda(clientesList.get(0), COMANDA_CODIGO + 1);
        comanda1.adicionarPedido(pedidosList.get(0));
        comanda1.adicionarPedido(pedidosList.get(1));
        comanda1.setStatusComanda(StatusComanda.ABERTA);
        comandas.add(comanda1);

        // Comanda 2
        Comanda comanda2 = new Comanda(clientesList.get(1), COMANDA_CODIGO + 2);
        comanda2.adicionarPedido(pedidosList.get(2));
        comanda2.adicionarPedido(pedidosList.get(3));
        comanda2.setStatusComanda(StatusComanda.FECHADA);
        comandas.add(comanda2);

        // Comanda 3
        Comanda comanda3 = new Comanda(clientesList.get(2), COMANDA_CODIGO + 3);
        comanda3.adicionarPedido(pedidosList.get(4));
        comanda3.adicionarPedido(pedidosList.get(5));
        comanda3.setStatusComanda(StatusComanda.PAGA);
        comanda3.setValorTotalFinal(130.20);
        comandas.add(comanda3);

        return comandas;
    }
}
