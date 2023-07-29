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
        String texto = "";
        List<Estoque> listaEstoque = estoqueController.recuperarTodos();
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
