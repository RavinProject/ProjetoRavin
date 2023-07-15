package views.estoque;

import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import controllers.EstoqueController;
import controllers.ProdutoController;
import utils.enums.TipoProduto;
import models.Estoque;
import models.Produto;
import views.View;

public class SubmenuEstoque extends View {

    public static void menu() {
        boolean exec = true;
        while (exec) {
            String opcao = solicitaEntradaDeDado(menuInicial());
            switch (opcao) {
                case "1" -> cadastrar();
                case "2" -> atualizar();
                case "3" -> listarEstoque();
                case "4" -> pesquisarEstoque();
                case "5" -> excluirProdutoEmEstoque();
                case "x" -> exec = false;
                default -> exibeDialogo("Opção inválida! Voltando...");
            }
        }
    }

    private static String menuInicial(){
        StringBuilder builder = new StringBuilder();
        builder.append("""
            ==================== RAVIN ====================
            ESTOQUE:
            1 - Cadastrar Produto
            2 - Alterar Produto
            3 - Listar Produtos em Estoque
            4 - Visualizar Produto em Estoque
            5 - Excluir Produto
            x - voltar
            """);
        return builder.toString();
    }

    private static void cadastrar() {
        EstoqueController estoqueController = new EstoqueController();
        ProdutoController produtoController = new ProdutoController();
        String codigoProduto = solicitaEntradaDeDado("Informe o código do produto:");
        if(estoqueController.recuperarPorCodigo(codigoProduto) != null){
            if(confirmaAcao("Já existe um produto com esse código! Clique em SIM para abrir a edição do produto ou NÃO para retornar.") == 1){
                atualizar();
            }else{
                return;
            }
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
        produtoController.inserir(produto);
        //
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

    private static void atualizar(){
        EstoqueController estoqueController = new EstoqueController();
        ProdutoController produtoController = new ProdutoController();
        String codigo = solicitaEntradaDeDado("Informe o código do produto que deseja alterar: ");
        Estoque estoque = estoqueController.recuperarPorCodigo(codigo);
        if (estoque != null) {
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
            produtoController.atualizar(produto);
            //
            estoque.setQuantidade(Double.parseDouble(solicitaEntradaDeDado("Qual a quantidade o produto " + produto.getNome() + " em estoque?", estoque.getQuantidade() + "").replace(',', '.')));
            estoque.setAlteradoEm(new Date());
            estoque.setAlteradoPor(null);
            //
            estoqueController.atualizar(estoque);
            imprimeProdutoEmEstoque(estoque);
        } else {
            exibeDialogo("Produto não encontrado com o código informado!");
        }
    }

    private static void pesquisarEstoque() {
        EstoqueController estoqueController = new EstoqueController();

        String produtoCodigo = solicitaEntradaDeDado("Informe o código do produto que deseja excluir: ");
        Estoque estoque = estoqueController.recuperarPorCodigo(produtoCodigo);
        if (estoque != null) {
            imprimeProdutoEmEstoque(estoque);
        } else {
            exibeDialogo("Produto não encontrado com o código informado!");
        }
    }

    private static void imprimeProdutoEmEstoque(Estoque estoque) {
        String estoqueDados = "ESTOQUE ID: " + estoque.getId() +
                        "\nQuantidade: " + estoque.getQuantidade() +
                        "\n======== PRODUTO ========" +
                        "\nId: " + estoque.getProduto().getId() +
                        "\nNome: " + estoque.getProduto().getNome() +
                        "\nDescrição: " + estoque.getProduto().getDescricao() +
                        "\nCódigo: " + estoque.getProduto().getCodigo() +
                        "\nPreço de Custo: " + estoque.getProduto().getPrecoCusto() +
                        "\nPreço de Venda: " + estoque.getProduto().getPrecoVenda() +
                        (estoque.getProduto().getTempoPreparo().equals("") ? "" : "\nTempo de Preparo: " + estoque.getProduto().getId()) +
                        "\nObservações: " + estoque.getProduto().getObservacoes() +
                        "\nTipo do Produto: " + estoque.getProduto().getTipoProduto() +
                        "\nAtivo: " + (estoque.getProduto().isAtivo() ? "Sim" : "Não") +
                        "";
        exibeDialogo(estoqueDados);
    }

    private static void listarEstoque() {
        EstoqueController estoqueController = new EstoqueController();
        String texto = "";
        List <Estoque> listaEstoque = estoqueController.pegarLista();
        if(listaEstoque.size() > 0){
            for (Estoque estoque : listaEstoque) {
                texto += "Código: " + estoque.getProduto().getCodigo() + " Quantidade: " + estoque.getQuantidade() + " Nome: "  + estoque.getProduto().getNome()+ (estoque.getProduto().isAtivo() ? " " : " (INATIVO) ") + "\n";
            }
        }else{
            texto = "Estoque vazio!";
        }
        exibeDialogo(texto);
    }

    private static void excluirProdutoEmEstoque() {
        EstoqueController estoqueController = new EstoqueController();
        String produtoCodigo = solicitaEntradaDeDado("Informe o código do produto que deseja excluir: ");
        Estoque estoque = estoqueController.recuperarPorCodigo(produtoCodigo);
        if(estoque != null){
            String estoqueDados = "ESTOQUE ID: " + estoque.getId() +
                        "\nQuantidade: " + estoque.getQuantidade() +
                        "\n======== PRODUTO ========" +
                        "\nId: " + estoque.getProduto().getId() +
                        "\nNome: " + estoque.getProduto().getNome() +
                        "\nDescrição: " + estoque.getProduto().getDescricao() +
                        "\nCódigo: " + estoque.getProduto().getCodigo() +
                        "\nPreço de Custo: " + estoque.getProduto().getPrecoCusto() +
                        "\nPreço de Venda: " + estoque.getProduto().getPrecoVenda() +
                        (estoque.getProduto().getTempoPreparo().equals("") ? "" : "\nTempo de Preparo: " + estoque.getProduto().getId()) +
                        "\nObservações: " + estoque.getProduto().getObservacoes() +
                        "\nTipo do Produto: " + estoque.getProduto().getTipoProduto() +
                        "\nAtivo: " + (estoque.getProduto().isAtivo() ? "Sim" : "Não") +
                        "\n\nDeseja continuar e excluir este produto do estoque?";
            if(confirmaAcao(estoqueDados) == JOptionPane.YES_OPTION){
                boolean excluido = estoqueController.remover(estoque);
                exibeDialogo(excluido ? "O estoque do produto foi excluído!" : "Não foi possível excluir o produto do estoque.");
            }else{
                exibeDialogo("Nada foi alterado!");
            }
        }else{
            exibeDialogo("Produto não encontrado com o código informado!");
        }

    }
}
