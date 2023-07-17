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

    private IClienteRepositorio clienteRepo;
    private IFuncionarioRepositorio funcionarioRepo;
    private IEstoqueRepositorio estoqueRepo;
    private IProdutoRepositorio produtoRepo;

    private ListasDados() {

        // Gerador de lista de clientes
        List<Cliente> clientesGerados = GerarClientes.montaLista();
        clienteRepo = new ClienteRepositorio(clientesGerados);

        // Gerador de lista de funcionarios
        List<Funcionario> funcionariosGerados = GerarFuncionarios.montaLista();
        funcionarioRepo = new FuncionarioRepositorio(funcionariosGerados);

        // Gerador de lista de produtos
        produtosList = GerarProdutos.montaLista();
        produtoRepo = new ProdutoRepositorio(produtosList);

        // Gerador de lista de estoque
        GerarEstoque gerarEstoque = new GerarEstoque(produtosList);
        estoqueList = gerarEstoque.generateEstoqueList();
        estoqueRepo = new EstoqueRepositorio(estoqueList);

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

}
