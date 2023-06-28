package dao;

import java.util.ArrayList;
import java.util.List;

import dao.dados.GerarClientes;
import dao.dados.GerarFuncionarios;
import models.Cliente;
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
    private List<Produto> listaProduto;
    private List<Mesa> listaMesas;

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
        return listaPessoas;
    }

}
