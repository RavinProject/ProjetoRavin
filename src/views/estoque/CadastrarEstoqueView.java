package views.estoque;

import java.util.Date;

import javax.swing.JOptionPane;

import controllers.interfaces.IEstoqueController;
import models.Estoque;
import models.Produto;
import utils.enums.TipoProduto;

import static views.View.*;
import static views.estoque.SubmenuEstoque.imprimeProdutoEmEstoque;
import static views.estoque.AtualizarEstoqueView.atualizar;

public class CadastrarEstoqueView {
    static void cadastrar(IEstoqueController estoqueController) {
        
        String codigoProduto = solicitaEntradaDeDado("Informe o código do produto:");
        if(estoqueController.produtoJaCadastrado(codigoProduto)){
            if(confirmaAcao("Já existe um produto com esse código! Clique em SIM para abrir a edição do produto ou NÃO para retornar.") == JOptionPane.YES_NO_OPTION){
                atualizar(estoqueController);
            }
            return;
        }
        
        Produto produto = new Produto();
        produto.setCodigo(codigoProduto);
        produto.setNome(solicitaEntradaDeDado("Informe o nome do produto:"));
        produto.setDescricao(solicitaEntradaDeDado("Informe uma descrição para o produto:"));
        produto.setPrecoCusto(Double.parseDouble(solicitaEntradaDeDado("Informe o preço de custo (1,99):").replace(',', '.')));
        produto.setPrecoVenda(Double.parseDouble(solicitaEntradaDeDado("Informe o preço de venda (1,99):").replace(',', '.')));
        produto.setTempoPreparo(solicitaEntradaDeDado("Informe o tempo de preparo"));
        produto.setObservacoes(solicitaEntradaDeDado("Informe uma observação para o produto:"));
        String stringTipoProduto = """
                Selecione o tipo do produto:
                1 - Bebidas
                2 - Carnes
                3 - Saladas
                4 - Sopas
                5 - Sobremesas""";
        produto.setTipoProduto(TipoProduto.values()[Integer.parseInt(solicitaEntradaDeDado(stringTipoProduto)) - 1]);
        produto.setAtivo(true);
        produto.setCriadoEm(new Date());
        produto.setCriadoPor(null);
        produto.setAlteradoEm(new Date());
        produto.setAlteradoPor(null);
        Estoque estoque = new Estoque();
        estoque.setProduto(produto);
        estoque.setQuantidade(Double.parseDouble(solicitaEntradaDeDado("Qual a quantidade o produto " + produto.getNome() + " em estoque?").replace(',', '.')));
        estoque.setCriadoEm(new Date());
        estoque.setCriadoPor(null);
        estoque.setAlteradoEm(new Date());
        estoque.setAlteradoPor(null);
        //
        estoqueController.inserir(estoque);
        imprimeProdutoEmEstoque(estoque);
    }
}
