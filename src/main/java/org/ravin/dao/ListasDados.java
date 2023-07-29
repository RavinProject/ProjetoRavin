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
    private final List<Estoque> estoqueList;
    private final List<Produto> produtosList;
    private final List<Mesa> mesaList;
    private final List<Reserva> reservaList;
    private final List<Pedido> pedidoList;
    private final List<Comanda> comandaList;
    private final IClienteRepositorioLista clienteRepo;
    private final IFuncionarioRepositorioLista funcionarioRepo;
    private final IEstoqueRepositorioLista estoqueRepo;
    private final IProdutoRepositorioLista produtoRepo;
    private final IPedidoRepositorioLista pedidoRepo;
    private final IMesaRepositorioLista mesaRepo;
    private final IReservaRepositorioLista reservaRepo;
    private final IComandaRepositorioLista comandaRepo;

    private ListasDados() {

        // Gerador de lista de clientes
        clientesList = GerarClientes.montaLista();
        clienteRepo = new ClienteRepositorioLista(clientesList);

        // Gerador de lista de funcionarios
        funcionariosList = GerarFuncionarios.montaLista();
        funcionarioRepo = new FuncionarioRepositorioLista(funcionariosList);

        // Gerador de lista de produtos
        produtosList = GerarProdutos.montaLista();
        produtoRepo = new ProdutoRepositorioLista(produtosList);

        // Gerador de lista de estoque
        GerarEstoque gerarEstoque = new GerarEstoque(produtosList);
        estoqueList = gerarEstoque.generateEstoqueList();
        estoqueRepo = new EstoqueRepositorioLista(estoqueList);

        // Gerador de lista de Pedidos
        pedidoList = GerarPedidos.montaLista(produtosList);
        pedidoRepo = new PedidoRepositorioLista(pedidoList);

        // Gerador de lista de Mesa
        mesaList = GerarMesas.montaLista(funcionariosList);
        mesaRepo = new MesaRepositorioLista(mesaList);

        // Gerador de lista de Comandas
        comandaList = GerarComandas.montaLista(clientesList, pedidoList, mesaList);
        comandaRepo = new ComandaRepositorioLista(comandaList);

        // Gerador de lista de Reservas
        reservaList = GerarReservas.montaLista(clientesList, mesaList);
        reservaRepo = new ReservaRepositorioLista(reservaList);

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
    public IClienteRepositorioLista getClienteRepositorio() {
        return clienteRepo;
    }
    public IFuncionarioRepositorioLista getFuncionarioRepositorio() {
        return funcionarioRepo;
    }
    public IEstoqueRepositorioLista getEstoqueRepositorio() {
        return estoqueRepo;
    }
    public IProdutoRepositorioLista getProdutoRepositorio() {
        return produtoRepo;
    }
    public IComandaRepositorioLista getComandaRepositorio() { return comandaRepo; }
    public IMesaRepositorioLista getMesaRepositorio() { return mesaRepo; }
    public IPedidoRepositorioLista getPedidoRepositorio() { return pedidoRepo; }
    public IReservaRepositorioLista getReservaRepositorio() { return reservaRepo; }

}
