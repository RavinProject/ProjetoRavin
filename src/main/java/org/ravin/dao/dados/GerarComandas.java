package org.ravin.dao.dados;

import org.ravin.models.Cliente;
import org.ravin.models.Comanda;
import org.ravin.models.Mesa;
import org.ravin.models.Pedido;
import org.ravin.services.comanda.AdicionarPedidoEmComandaService;
import org.ravin.services.comanda.interfaces.IAdicionarPedidoEmComandaService;
import org.ravin.utils.enums.StatusComanda;
import org.ravin.utils.enums.StatusMesa;

import java.util.ArrayList;
import java.util.List;

public class GerarComandas {

    private static final String COMANDA_CODIGO = "COMANDA";
    private static final IAdicionarPedidoEmComandaService adicionarPedidoEmComanda = new AdicionarPedidoEmComandaService();

    public static List<Comanda> montaLista(List<Cliente> clientesList, List<Pedido> pedidosList, List<Mesa> mesasList) {
        List<Comanda> comandas = new ArrayList<>();

        // Comanda 1 Status Aberta, Mesa Ocupada
        Comanda comanda1 = new Comanda(clientesList.get(0), COMANDA_CODIGO + 1, mesasList.get(0));
        adicionarPedidoEmComanda.adicionarPedidoEmComanda(comanda1, pedidosList.get(0));
        adicionarPedidoEmComanda.adicionarPedidoEmComanda(comanda1, pedidosList.get(1));
        comanda1.setStatusComanda(StatusComanda.ABERTA);
        mesasList.get(0).setStatusMesa(StatusMesa.OCUPADA);
        comandas.add(comanda1);

        // Comanda 2 Status Fechada, Mesa Ocupada
        Comanda comanda2 = new Comanda(clientesList.get(1), COMANDA_CODIGO + 2, mesasList.get(1));
        adicionarPedidoEmComanda.adicionarPedidoEmComanda(comanda2, pedidosList.get(2));
        adicionarPedidoEmComanda.adicionarPedidoEmComanda(comanda2, pedidosList.get(3));
        comanda2.setStatusComanda(StatusComanda.FECHADA);
        mesasList.get(1).setStatusMesa(StatusMesa.OCUPADA);
        comandas.add(comanda2);

        // Comanda 3 Status Paga, Mesa Livre
        Comanda comanda3 = new Comanda(clientesList.get(2), COMANDA_CODIGO + 3, mesasList.get(2));
        adicionarPedidoEmComanda.adicionarPedidoEmComanda(comanda3, pedidosList.get(4));
        adicionarPedidoEmComanda.adicionarPedidoEmComanda(comanda3, pedidosList.get(5));
        comanda3.setStatusComanda(StatusComanda.PAGA);
        mesasList.get(2).setStatusMesa(StatusMesa.LIVRE);
        comanda3.setTotalLiquido(130.20);
        comandas.add(comanda3);

        return comandas;
    }
}