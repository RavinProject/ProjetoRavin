package views.estoque;

import controllers.interfaces.IEstoqueController;
import models.Estoque;

import static views.View.exibeDialogo;
import static views.View.solicitaEntradaDeDado;
import static views.estoque.SubmenuEstoque.imprimeProdutoEmEstoque;

public class RecuperarEstoqueView {

    static void pesquisarEstoque(IEstoqueController estoqueController) {
        String produtoCodigo = solicitaEntradaDeDado("Informe o código do produto que deseja consultar: ");
        Estoque estoque = estoqueController.recuperarPorCodigo(produtoCodigo);
        if (estoque != null) {
            imprimeProdutoEmEstoque(estoque);
        } else {
            exibeDialogo("Produto não encontrado com o código informado!");
        }
    }

}
