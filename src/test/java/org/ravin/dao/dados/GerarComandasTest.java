package org.ravin.dao.dados;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.ravin.models.*;
import org.ravin.utils.enums.StatusComanda;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GerarComandasTest {

    List<Cliente> clientesList;
    List<Pedido> pedidosList;
    List<Funcionario> funcionarioList;
    List<Comanda> comandaList;
    List<Produto> produtosList;
    List<Mesa> mesaList;

    @BeforeEach
    void setUp() {
        funcionarioList = GerarFuncionarios.montaLista();
        clientesList = GerarClientes.montaLista();
        produtosList = GerarProdutos.montaLista();
        pedidosList = GerarPedidos.montaLista(produtosList);
        mesaList = GerarMesas.montaLista(funcionarioList);
        comandaList = GerarComandas.montaLista(clientesList, pedidosList, mesaList);
    }

    @Test
    void montaLista() {
        List<Comanda> comandas = GerarComandas.montaLista(clientesList, pedidosList, mesaList);

        assertEquals(3, comandas.size());

        // Test Comanda 1
        Comanda comanda1 = comandas.get(0);
        assertEquals(clientesList.get(0), comanda1.getCliente());
        assertEquals(2, comanda1.getPedidos().size());
        assertEquals(StatusComanda.ABERTA, comanda1.getStatusComanda());

        // Test Comanda 2
        Comanda comanda2 = comandas.get(1);
        assertEquals(clientesList.get(1), comanda2.getCliente());
        assertEquals(2, comanda2.getPedidos().size());
        assertEquals(StatusComanda.FECHADA, comanda2.getStatusComanda());

        // Test Comanda 3
        Comanda comanda3 = comandas.get(2);
        assertEquals(clientesList.get(2), comanda3.getCliente());
        assertEquals(2, comanda3.getPedidos().size());
        assertEquals(StatusComanda.PAGA, comanda3.getStatusComanda());
        assertEquals(130.20, comanda3.getTotalLiquido(), 0.01);
    }
}
