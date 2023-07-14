package views.estoque;

import controllers.interfaces.IClienteController;
import controllers.interfaces.IEstoqueController;
import models.Cliente;
import models.Estoque;
import models.Produto;
import utils.DateUtils;
import utils.enums.TipoProduto;

import java.util.Date;
import java.util.NoSuchElementException;

import static views.estoque.SubmenuEstoque.imprimeProdutoEmEstoque;
import static views.View.exibeDialogo;
import static views.View.solicitaEntradaDeDado;


public class AtualizarEstoqueView {
    static void atualizar(IEstoqueController estoqueController) {
        String codigo = solicitaEntradaDeDado("Informe o código do produto que deseja alterar: ");
        try{
            Estoque estoque = estoqueController.recuperarPorCodigo(codigo);
            Produto produto = estoque.getProduto();
            produto.setCodigo(solicitaEntradaDeDado("Informe o código do produto: ", produto.getCodigo()));
            produto.setNome(solicitaEntradaDeDado("Informe o nome do produto:", produto.getNome()));
            produto.setDescricao(solicitaEntradaDeDado("Informe uma descrição para o produto:", produto.getDescricao()));
            produto.setPrecoCusto(Double.parseDouble(solicitaEntradaDeDado("Informe o preço de custo (1,99):", ("" + produto.getPrecoCusto()).replace(".", ",")).replace(',', '.')));
            produto.setPrecoVenda(Double.parseDouble(solicitaEntradaDeDado("Informe o preço de venda (1,99):", ("" + produto.getPrecoVenda()).replace(".", ",")).replace(',', '.')));
            produto.setTempoPreparo(solicitaEntradaDeDado("Informe o tempo de preparo", produto.getTempoPreparo()));
            produto.setObservacoes(solicitaEntradaDeDado("Informe uma observação para o produto:", produto.getObservacoes()));
            String stringTipoProduto = """
                    Selecione o tipo do produto:
                    1 - Bebidas
                    2 - Carnes
                    3 - Saladas
                    4 - Sopas
                    5 - Sobremesas""";
            produto.setTipoProduto(TipoProduto.values()[Integer.parseInt(solicitaEntradaDeDado(stringTipoProduto, (produto.getTipoProduto().ordinal() + 1) + "")) - 1]);
            boolean ativo = solicitaEntradaDeDado("Ativo?\n 0 - Não \n 1 - Sim", produto.isAtivo() ? "1" : "0").equals("1") ? true : false;
            produto.setAtivo(ativo);
            estoque.getProduto().setAlteradoEm(new Date());
            estoque.getProduto().setAlteradoPor(null);
            //
            estoque.setQuantidade(Double.parseDouble(solicitaEntradaDeDado("Qual a quantidade o produto " + produto.getNome() + " em estoque?", estoque.getQuantidade() + "").replace(',', '.')));
            estoque.setAlteradoEm(new Date());
            estoque.setAlteradoPor(null);
            //
            estoqueController.atualizar(estoque);
            imprimeProdutoEmEstoque(estoque);
        }catch(NoSuchElementException e){
            exibeDialogo("Produto não encontrado com o código informado!");

        }
    }
}
