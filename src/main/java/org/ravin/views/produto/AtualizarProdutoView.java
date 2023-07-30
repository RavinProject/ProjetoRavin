package org.ravin.views.produto;

import org.ravin.models.Produto;
import org.ravin.utils.enums.TipoProduto;

import java.util.Date;

import static org.ravin.views.View.solicitaEntradaDeDado;

public class AtualizarProdutoView {
    public static void atualizarProduto(Produto produto){
        produto.setCodigo(solicitaEntradaDeDado("Informe o código do produto: ", produto.getCodigo()));
        produto.setNome(solicitaEntradaDeDado("Informe o nome do produto:", produto.getNome()));
        produto.setDescricao(solicitaEntradaDeDado("Informe uma descrição para o produto:", produto.getDescricao()));
        produto.setPrecoCusto(Double.parseDouble(solicitaEntradaDeDado("Informe o preço de custo (1,99):", (String.valueOf(produto.getPrecoCusto())).replace(".", ",")).replace(',', '.')));
        produto.setPrecoVenda(Double.parseDouble(solicitaEntradaDeDado("Informe o preço de venda (1,99):", (String.valueOf(produto.getPrecoVenda())).replace(".", ",")).replace(',', '.')));
        produto.setTempoPreparo(solicitaEntradaDeDado("Informe o tempo de preparo", produto.getTempoPreparo()));
        produto.setObservacoes(solicitaEntradaDeDado("Informe uma observação para o produto:", produto.getObservacoes()));
        produto.setTipoProduto(solicitaTipoProduto(produto.getTipoProduto()));
        produto.setAtivo(solicitaAtivoProduto(produto.isAtivo()));
        produto.setAlteradoEm(new Date());
        produto.setAlteradoPor(null);
    }
    private static TipoProduto solicitaTipoProduto(TipoProduto tipoAtual) {
        String stringTipoProduto = """
                Selecione o tipo do produto:
                1 - Bebidas
                2 - Carnes
                3 - Saladas
                4 - Sopas
                5 - Sobremesas""";
        int tipo = Integer.parseInt(solicitaEntradaDeDado(stringTipoProduto, String.valueOf(tipoAtual.ordinal() + 1))) - 1;
        return TipoProduto.values()[tipo];
    }

    private static boolean solicitaAtivoProduto(boolean isAtivo) {
        String ativoStr = solicitaEntradaDeDado("Ativo?\n 0 - Não \n 1 - Sim", isAtivo ? "1" : "0");
        return ativoStr.equals("1");
    }
}
