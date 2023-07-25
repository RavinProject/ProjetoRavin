package org.ravin.views.estoque;

import org.ravin.controllers.interfaces.IEstoqueController;
import org.ravin.controllers.interfaces.IProdutoController;
import org.ravin.models.Estoque;
import org.ravin.models.Produto;
import org.ravin.utils.enums.TipoProduto;
import org.ravin.utils.exceptions.EntidadeNaoEncontradaException;

import java.util.Date;

import static org.ravin.views.View.exibeDialogo;
import static org.ravin.views.View.solicitaEntradaDeDado;
import static org.ravin.views.estoque.SubmenuEstoque.imprimeProdutoEmEstoque;

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

    static void atualizarProduto(Produto produto){
        produto.setCodigo(solicitaEntradaDeDado("Informe o código do produto: ", produto.getCodigo()));
        produto.setNome(solicitaEntradaDeDado("Informe o nome do produto:", produto.getNome()));
        produto.setDescricao(solicitaEntradaDeDado("Informe uma descrição para o produto:", produto.getDescricao()));
        produto.setPrecoCusto(Double.parseDouble(solicitaEntradaDeDado("Informe o preço de custo (1,99):", ("" + produto.getPrecoCusto()).replace(".", ",")).replace(',', '.')));
        produto.setPrecoVenda(Double.parseDouble(solicitaEntradaDeDado("Informe o preço de venda (1,99):", ("" + produto.getPrecoVenda()).replace(".", ",")).replace(',', '.')));
        produto.setTempoPreparo(solicitaEntradaDeDado("Informe o tempo de preparo", produto.getTempoPreparo()));
        produto.setObservacoes(solicitaEntradaDeDado("Informe uma observação para o produto:", produto.getObservacoes()));
        produto.setTipoProduto(solicitaTipoProduto(produto.getTipoProduto()));
        produto.setAtivo(solicitaAtivoProduto(produto.isAtivo()));
        produto.setAlteradoEm(new Date());
        produto.setAlteradoPor(null);
    }

    static void atualizarQuantidadeEstoque(Estoque estoque){
        estoque.setQuantidade(solicitaQuantidadeEstoque(estoque.getProduto().getNome(), estoque.getQuantidade()));
        estoque.setAlteradoEm(new Date());
        estoque.setAlteradoPor(null);
    }

    static TipoProduto solicitaTipoProduto(TipoProduto tipoAtual) {
        String stringTipoProduto = """
                Selecione o tipo do produto:
                1 - Bebidas
                2 - Carnes
                3 - Saladas
                4 - Sopas
                5 - Sobremesas""";
        int tipo = Integer.parseInt(solicitaEntradaDeDado(stringTipoProduto, (tipoAtual.ordinal() + 1) + "")) - 1;
        return TipoProduto.values()[tipo];
    }

    static boolean solicitaAtivoProduto(boolean isAtivo) {
        String ativoStr = solicitaEntradaDeDado("Ativo?\n 0 - Não \n 1 - Sim", isAtivo ? "1" : "0");
        return ativoStr.equals("1");
    }

    static double solicitaQuantidadeEstoque(String nomeProduto, double quantidadeAtual){
        String quantidadeStr = solicitaEntradaDeDado("Qual a quantidade o produto " + nomeProduto + " em estoque?", quantidadeAtual + "");
        return Double.parseDouble(quantidadeStr.replace(',', '.'));
    }
}