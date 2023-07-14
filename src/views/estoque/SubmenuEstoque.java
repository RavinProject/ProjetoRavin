package views.estoque;


import controllers.EstoqueController;
import controllers.interfaces.IEstoqueController;
import dao.ListasDados;
import dao.interfaces.IEstoqueRepositorio;
import models.Estoque;

import javax.swing.*;

import static views.View.exibeDialogo;
// import static views.cliente.AtualizarClienteView.atualizar;
// import static views.cliente.CadastrarClienteView.*;
// import static views.cliente.ExcluirClienteView.excluirCliente;
// import static views.cliente.RecuperarClienteView.listarClientes;
// import static views.cliente.RecuperarClienteView.pesquisarClientePorCpf;
import static views.estoque.RecuperarEstoqueView.pesquisarEstoque;

import java.util.List;

public class SubmenuEstoque {

    public static void menu() {
        // Injeção de Dependência
        IEstoqueRepositorio estoqueRepo = ListasDados.getInstance().getEstoqueRepositorio();
        IEstoqueController estoqueController = new EstoqueController(estoqueRepo);

        boolean exec = true;
        while (exec) {
            String opcao = JOptionPane.showInputDialog(menuInicial());
            switch (opcao) {
                // case "1" -> cadastrar(clienteController);
                // case "2" -> atualizar(clienteController);
                case "3" -> listarEstoque(estoqueController);
                case "4" -> pesquisarEstoque(estoqueController);
                // case "5" -> excluirCliente(clienteController);
                case "x" -> exec = false;
                default -> exibeDialogo("Opção inválida! Voltando...");
            }
        }
    }

    private static String menuInicial(){
        StringBuilder builder = new StringBuilder();
		builder.append("""
            ==================== RAVIN ==================== 

            1 - Cadastrar Produto
            2 - Alterar Produto 
            3 - Listar Produtos em Estoque
            4 - Visualizar Produto em Estoque
            5 - Excluir Produto
            x - voltar
            """);
        return builder.toString();
    }

    static void imprimeProdutoEmEstoque(Estoque estoque) {
        String estoqueDados = "ESTOQUE ID: " + estoque.getId() +
                        "\nQuantidade: " + estoque.getQuantidade() +
                        "\n======== PRODUTO ========" +
                        "\nId: " + estoque.getProduto().getId() +
                        "\nNome: " + estoque.getProduto().getNome() +
                        "\nDescrição: " + estoque.getProduto().getDescricao() +
                        "\nCódigo: " + estoque.getProduto().getCodigo() +
                        "\nPreço de Custo: " + estoque.getProduto().getPrecoCusto() +
                        "\nPreço de Venda: " + estoque.getProduto().getPrecoVenda() +
                        (estoque.getProduto().getTempoPreparo().equals("") ? "" : "\nTempo de Preparo: " + estoque.getProduto().getId()) +
                        "\nObservações: " + estoque.getProduto().getObservacoes() +
                        "\nTipo do Produto: " + estoque.getProduto().getTipoProduto() +
                        "\nAtivo: " + (estoque.getProduto().isAtivo() ? "Sim" : "Não") +
                        "";
        exibeDialogo(estoqueDados);
    }

    static void listarEstoque(IEstoqueController estoqueController) {
        String texto = "";
        List <Estoque> listaEstoque = estoqueController.pegarLista();
        if(listaEstoque.size() > 0){
            for (Estoque estoque : listaEstoque) {
                texto += "Código: " + estoque.getProduto().getCodigo() + " Quantidade: " + estoque.getQuantidade() + " Nome: "  + estoque.getProduto().getNome()+ (estoque.getProduto().isAtivo() ? " " : " (INATIVO) ") + "\n";
            }
        }else{
            texto = "Estoque vazio!";
        }
        exibeDialogo(texto);
    }
}
