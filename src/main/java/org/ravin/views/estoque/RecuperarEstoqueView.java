package org.ravin.views.estoque;

import org.ravin.controllers.interfaces.IEstoqueController;
import org.ravin.models.Estoque;

import java.util.NoSuchElementException;

import static org.ravin.views.View.exibeDialogo;
import static org.ravin.views.View.solicitaEntradaDeDado;
import static org.ravin.views.estoque.SubmenuEstoque.imprimeProdutoEmEstoque;

public class RecuperarEstoqueView {

    static void pesquisarEstoque(IEstoqueController estoqueController) {
        String produtoCodigo = solicitaEntradaDeDado("Informe o código do produto que deseja consultar: ");
        try{
            Estoque estoque = estoqueController.recuperarPorCodigo(produtoCodigo);
            imprimeProdutoEmEstoque(estoque);
        }catch(NoSuchElementException e){
            exibeDialogo(e.getMessage());
        }
    }

}
