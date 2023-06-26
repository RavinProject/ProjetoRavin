package dao;

import java.util.ArrayList;
import java.util.List;

import Models.Cargo;
import Models.Cliente;
import Models.Funcionario;
import dao.dados.GerarCargos;
import dao.dados.GerarClientes;
import dao.dados.GerarFuncionarios;

/**
 * Padrão Singleton
 */
public class ListasDados {

    private static ListasDados instancia;

    private List<Cliente> listaClientes;
    private List<Funcionario> listaFuncionarios;
    private List<Cargo> listaCargos;


    private ListasDados() {
        listaCargos = GerarCargos.pegaLista();
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
