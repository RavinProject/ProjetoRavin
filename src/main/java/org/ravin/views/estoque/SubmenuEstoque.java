package org.ravin.views.estoque;

import org.ravin.controllers.EstoqueController;
import org.ravin.controllers.ProdutoController;
import org.ravin.controllers.interfaces.IEstoqueController;
import org.ravin.controllers.interfaces.IProdutoController;
import org.ravin.models.Estoque;
import org.ravin.models.Produto;
import org.ravin.services.EstoqueService;
import org.ravin.services.ProdutoService;
import org.ravin.services.interfaces.IEstoqueService;
import org.ravin.services.interfaces.IProdutoService;
import org.ravin.utils.enums.TipoProduto;
import org.ravin.views.View;

import javax.swing.*;
import java.util.Date;
import java.util.List;

import static org.ravin.views.estoque.AtualizarEstoqueView.atualizarEstoque;
import static org.ravin.views.estoque.CadastrarEstoqueView.cadastrarEstoque;
import static org.ravin.views.estoque.ExcluirEstoqueView.excluirProdutoEmEstoque;
import static org.ravin.views.estoque.RecuperarEstoqueView.listarEstoque;
import static org.ravin.views.estoque.RecuperarEstoqueView.pesquisarEstoque;

public class SubmenuEstoque extends View {

    public static void menuEstoque() {
        // Injeção de Dependência
        IEstoqueService estoqueService = new EstoqueService();
        IEstoqueController estoqueController = new EstoqueController(estoqueService);

        IProdutoService produtoService = new ProdutoService();
        IProdutoController produtoController = new ProdutoController(produtoService);

        boolean exec = true;
        while (exec) {
            String opcao = solicitaEntradaDeDado(menuInicial());
            switch (opcao) {
                case "1" -> cadastrarEstoque(estoqueController, produtoController);
                case "2" -> atualizarEstoque(estoqueController, produtoController);
                case "3" -> listarEstoque(estoqueController);
                case "4" -> pesquisarEstoque(estoqueController);
                case "5" -> excluirProdutoEmEstoque(estoqueController);
                case "x" -> exec = false;
                default -> exibeDialogo("Opção inválida! Voltando...");
            }
        }
    }

    private static String menuInicial(){
        StringBuilder builder = new StringBuilder();
        builder.append("""
            ==================== RAVIN ====================
            ESTOQUE:
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
}
