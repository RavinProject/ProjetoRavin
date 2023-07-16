package views.estoque;

import controllers.interfaces.IEstoqueController;
import models.Estoque;
import models.Produto;
import utils.enums.TipoProduto;

import javax.swing.*;
import java.util.Date;
import java.util.NoSuchElementException;

import static views.View.confirmaAcao;
import static views.View.solicitaEntradaDeDado;
import static views.estoque.AtualizarEstoqueView.atualizarProduto;
import static views.estoque.SubmenuEstoque.imprimeProdutoEmEstoque;

public class CadastrarEstoqueView {
    static void cadastrar(IEstoqueController estoqueController) {
        
        String codigoProduto = solicitaEntradaDeDado("Informe o código do produto:");
        Estoque estoque = new Estoque();
        // busco o estoque com o mesmo código de produto
        if(estoqueController.estoqueJaCadastrado(codigoProduto)){
            try{
                //sobrescrevo o objeto com o estoque já existente
                estoque = estoqueController.recuperarPorCodigo(codigoProduto);
            }catch(NoSuchElementException e){
                //
            }
            // como já existe eum estoque, pergunto se quer editar o produto
            if(confirmaAcao("Já existe um produto com esse código! Clique em SIM para abrir a edição do produto ou NÃO para continuar e informar a quantidade.") == JOptionPane.YES_NO_OPTION){
                atualizarProduto(estoque.getProduto());
            }
        }else{
            // se não existe crio um novo produto
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
            //adiciono o produto ao novo estoque
            estoque.setProduto(produto);
            estoque.setCriadoEm(new Date());
            estoque.setCriadoPor(null);
        }
        
        // por fim atualizo a quantidade do produto no estoque  
        estoque.setQuantidade(Double.parseDouble(solicitaEntradaDeDado("Qual a quantidade o produto " + estoque.getProduto().getNome() + " em estoque?", estoque.getQuantidade() + "").replace(',', '.')));
        estoque.setAlteradoEm(new Date());
        estoque.setAlteradoPor(null);
        //
        estoqueController.inserir(estoque);
        imprimeProdutoEmEstoque(estoque);
    }
}