package dao;

import java.util.ArrayList;
import java.util.List;

import dao.dados.GerarClientes;
import dao.dados.GerarFuncionarios;
import models.Cliente;
import models.Estoque;
import models.Funcionario;
import models.Mesa;
import models.Pessoa;
import models.Produto;

/**
 * Padrão Singleton
 */
public class ListasDados {

    private static ListasDados instancia;

    private List<Pessoa> listaPessoas;
    private List<Estoque> listaEstoque;
    private List<Produto> listaProduto;

    private ListasDados() {
        listaPessoas = new ArrayList<Pessoa>();
    }

    public static ListasDados getInstance() {
        if (instancia == null) {
            instancia = new ListasDados();
        }
        return instancia;
    }

    public List<Pessoa> getListaPessoas() {
        if(listaPessoas == null){
            listaPessoas = new ArrayList<Pessoa>();
        }
        return listaPessoas;
    }

    public List<Estoque> getListaEstoque() {
        if(listaEstoque == null){
            listaEstoque = new ArrayList<Estoque>();
        }
        return listaEstoque;
    }

    public List<Produto> getListaProduto() {
        if(listaProduto == null){
            listaProduto = new ArrayList<Produto>();
        }
        return listaProduto;
    }

}
