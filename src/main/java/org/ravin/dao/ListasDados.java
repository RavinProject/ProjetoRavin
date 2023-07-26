package org.ravin.dao;

import org.ravin.dao.dados.*;
import org.ravin.dao.interfaces.*;
import org.ravin.models.*;

import java.util.List;

/**
 * Padrão Singleton
 */
public class ListasDados {

    private static ListasDados instancia;
    private List<Cliente> clientesList;
    private List<Funcionario> funcionariosList;
    private List<Estoque> estoqueList;
    private List<Produto> produtosList;
    private List<Mesa> mesaList;
    private List<Reserva> reservaList;
    private List<Pedido> pedidoList;
    private List<Comanda> comandaList;
    private final IClienteRepositorio clienteRepo;
    private final IFuncionarioRepositorio funcionarioRepo;
    private final IEstoqueRepositorio estoqueRepo;
    private final IProdutoRepositorio produtoRepo;
    private final IPedidoRepositorio pedidoRepo;
    private final IMesaRepositorio mesaRepo;
    private IReservaRepositorio reservaRepo;
    private final IComandaRepositorio comandaRepo;

    private ListasDados() {

        // Gerador de lista de clientes
        clientesList = GerarClientes.montaLista();
        clienteRepo = new ClienteRepositorio(clientesList);

        // Gerador de lista de funcionarios
        funcionariosList = GerarFuncionarios.montaLista();
        funcionarioRepo = new FuncionarioRepositorio(funcionariosList);

        // Gerador de lista de produtos
        produtosList = GerarProdutos.montaLista();
        produtoRepo = new ProdutoRepositorio(produtosList);

        // Gerador de lista de estoque
        GerarEstoque gerarEstoque = new GerarEstoque(produtosList);
        estoqueList = gerarEstoque.generateEstoqueList();
        estoqueRepo = new EstoqueRepositorio(estoqueList);

        // Gerador de lista de Pedidos
        pedidoList = GerarPedidos.montaLista();
        pedidoRepo = new PedidoRepositorio(pedidoList);

        // Gerador de lista de Comandas
        comandaList = GerarComandas.montaLista(clientesList, pedidoList);
        comandaRepo = new ComandaRepositorio(comandaList);

        // Gerador de lista de Mesa
        mesaList = GerarMesas.montaLista(funcionariosList, comandaList);
        mesaRepo = new MesaRepositorio(mesaList);

        // Gerador de lista de Reservas
        reservaList = GerarReservas.montaLista(clientesList, mesaList);
        reservaRepo = new ReservaRepositorio(reservaList);

        // Atualizando as listas após as inserções
        clientesList = clienteRepo.pegarLista();
        funcionariosList = funcionarioRepo.pegarLista();
    }

    public static ListasDados getInstance() {
        if (instancia == null) {
            instancia = new ListasDados();
        }
        return instancia;
    }

    // get Listas
    public List<Cliente> getClientList() {
        return clientesList;
    }
    public List<Funcionario> getFuncionariosList() {
        return funcionariosList;
    }
    public List<Estoque> getEstoqueList() {
        return estoqueList;
    }
    public List<Produto> getProdutosList() {
        return produtosList;
    }
    public List<Mesa> getMesaList() { return mesaList; }
    public List<Comanda> getComandaList() { return comandaList; }
    public List<Pedido> getPedidoList() { return pedidoList; }
    public List<Reserva> getReservaList() { return reservaList; }

    // get Repositorios
    public IClienteRepositorio getClienteRepositorio() {
        return clienteRepo;
    }
    public IFuncionarioRepositorio getFuncionarioRepositorio() {
        return funcionarioRepo;
    }
    public IEstoqueRepositorio getEstoqueRepositorio() {
        return estoqueRepo;
    }
    public IProdutoRepositorio getProdutoRepositorio() {
        return produtoRepo;
    }
    public IComandaRepositorio getComandaRepositorio() { return comandaRepo; }
    public IMesaRepositorio getMesaRepositorio() { return mesaRepo; }
    public IPedidoRepositorio gerPedidoRepositorio() { return pedidoRepo; }
    public IReservaRepositorio getReservaRepositorio() { return reservaRepo; }

}
