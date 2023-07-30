package org.ravin.views.estoque;

import org.ravin.controllers.interfaces.IEstoqueController;
import org.ravin.controllers.interfaces.IProdutoController;
import org.ravin.models.Estoque;
import org.ravin.models.Produto;
import org.ravin.utils.exceptions.EntidadeNaoEncontradaException;

import java.util.Date;

import static org.ravin.views.View.exibeDialogo;
import static org.ravin.views.View.solicitaEntradaDeDado;
import static org.ravin.views.estoque.SubmenuEstoque.imprimeProdutoEmEstoque;
import static org.ravin.views.produto.AtualizarProdutoView.atualizarProduto;

public class AtualizarEstoqueView {

    static void atualizarEstoque(IEstoqueController estoqueController, IProdutoController produtoController) {
        String codigo = solicitaEntradaDeDado("Informe o código do produto que deseja alterar: ");
        if (codigo == null) return;
        try{
            Estoque estoque = estoqueController.recuperarPorCodigo(codigo);
            Produto produto = estoque.getProduto();
            atualizarProduto(produto);
            produtoController.atualizar(produto);
            atualizarQuantidadeEstoque(estoque);
            estoqueController.atualizar(estoque);
            imprimeProdutoEmEstoque(estoque);
        }catch(EntidadeNaoEncontradaException e){
            exibeDialogo(e.getMessage());
        }
    }

    static void atualizarQuantidadeEstoque(Estoque estoque){
        estoque.setQuantidade(solicitaQuantidadeEstoque(estoque.getProduto().getNome(), estoque.getQuantidade()));
        estoque.setAlteradoEm(new Date());
        estoque.setAlteradoPor(null);
    }

    static double solicitaQuantidadeEstoque(String nomeProduto, double quantidadeAtual){
        String quantidadeStr = solicitaEntradaDeDado("Qual a quantidade o produto " + nomeProduto + " em estoque?", String.valueOf(quantidadeAtual));
        return Double.parseDouble(quantidadeStr.replace(',', '.'));
    }
}