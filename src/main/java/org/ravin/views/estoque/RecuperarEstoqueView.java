package org.ravin.views.estoque;

import org.ravin.controllers.interfaces.IEstoqueController;
import org.ravin.models.Estoque;
import org.ravin.utils.exceptions.EntidadeNaoEncontradaException;

import java.util.List;

import static org.ravin.views.View.exibeDialogo;
import static org.ravin.views.View.solicitaEntradaDeDado;
import static org.ravin.views.estoque.SubmenuEstoque.imprimeProdutoEmEstoque;

public class RecuperarEstoqueView {

    static void pesquisarEstoque(IEstoqueController estoqueController) {
        String produtoCodigo = solicitaEntradaDeDado("Informe o código do produto que deseja consultar: ");
        if (produtoCodigo == null) return;
        try{
            Estoque estoque = estoqueController.recuperarPorCodigo(produtoCodigo);
            imprimeProdutoEmEstoque(estoque);
        }catch(EntidadeNaoEncontradaException e){
            exibeDialogo(e.getMessage());
        }
    }

    static void listarEstoque(IEstoqueController estoqueController) {
        StringBuilder texto = new StringBuilder();
        List<Estoque> listaEstoque = estoqueController.recuperarTodos();
        if(listaEstoque.size() > 0){
            for (Estoque estoque : listaEstoque) {
                texto.append("Código: ").append(estoque.getProduto().getCodigo()).
                        append(" Quantidade: ").append(estoque.getQuantidade()).
                        append(" Nome: ").append(estoque.getProduto().getNome()).
                        append(estoque.getProduto().isAtivo() ? " " : " (INATIVO) ").
                        append("\n");
            }
        }else{
            texto = new StringBuilder("Estoque vazio!");
        }
        exibeDialogo(texto.toString());
    }
}
