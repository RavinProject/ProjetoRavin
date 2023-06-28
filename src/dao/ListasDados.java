package dao;

import java.util.ArrayList;
import java.util.List;

import dao.dados.GerarClientes;
import dao.dados.GerarFuncionarios;
import models.Cliente;
import models.Funcionario;
import models.Mesa;
import models.Produto;

/**
 * Padrão Singleton
 */
public class ListasDados {

    private static ListasDados instancia;

    private List<Cliente> listaClientes;
    private List<Funcionario> listaFuncionarios;
    private List<Produto> listaProduto;
    private List<Mesa> listaMesas;



    private ListasDados() {
        listaClientes = GerarClientes.pegaLista();
        listaFuncionarios = GerarFuncionarios.pegaLista();
    }

    public static ListasDados getInstance() {
        if (instancia == null) {
            instancia = new ListasDados();
        }
        return instancia;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public List<Funcionario> getListaFuncionarios() {
        return listaFuncionarios;
    }
}
