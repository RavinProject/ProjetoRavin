package views.estoque;

import controllers.interfaces.IEstoqueController;
import models.Estoque;

import java.util.NoSuchElementException;

import static views.View.exibeDialogo;
import static views.View.solicitaEntradaDeDado;
import static views.estoque.SubmenuEstoque.imprimeProdutoEmEstoque;

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
