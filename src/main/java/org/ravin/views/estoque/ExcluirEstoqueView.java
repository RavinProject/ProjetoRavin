package org.ravin.views.estoque;

import org.ravin.controllers.interfaces.IEstoqueController;
import org.ravin.models.Estoque;

import javax.swing.*;
import java.util.NoSuchElementException;

import static org.ravin.views.View.*;

public class ExcluirEstoqueView {
    static void excluirProdutoEmEstoque(IEstoqueController estoqueController) {
        String produtoCodigo = solicitaEntradaDeDado("Informe o código do produto que deseja excluir: ");
        if (produtoCodigo == null) return;
        Estoque estoque = estoqueController.recuperarPorCodigo(produtoCodigo);
        if(estoque != null){
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
                    "\n\nDeseja continuar e excluir este produto do estoque?";
            if(confirmaAcao(estoqueDados) == JOptionPane.YES_OPTION){
                boolean excluido = estoqueController.remover(estoque);
                exibeDialogo(excluido ? "O estoque do produto foi excluído!" : "Não foi possível excluir o produto do estoque.");
            }else{
                exibeDialogo("Nada foi alterado!");
            }
        }else{
            exibeDialogo("Produto não encontrado com o código informado!");
        }
    }
}