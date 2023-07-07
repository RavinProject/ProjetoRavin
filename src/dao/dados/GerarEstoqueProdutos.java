package dao.dados;

import java.util.List;
import java.util.Random;

import controllers.EstoqueController;
import controllers.ProdutoControler;
import dao.enuns.TipoProduto;
import models.Estoque;
import models.Produto;


public class GerarEstoqueProdutos {

    public static void montaLista() {
        EstoqueController estoqueController = new EstoqueController();
        ProdutoControler produtoController = new ProdutoControler();
        
        Random random = new Random();

        // Produto 1
        Produto produto1 = new Produto("Coca-Cola 600ml", "refrigerante de cola", "COCA600", 3.80, 6.50, TipoProduto.BEBIDAS);
        produtoController.inserir(produto1);
        estoqueController.inserir(new Estoque(produto1, random.nextInt(100)));

        // Produto 2
        Produto produto2 = new Produto("Água Mineral 500ml", "água mineral sem gás", "AGUA500", 2.50, 4.00, TipoProduto.BEBIDAS);
        produtoController.inserir(produto2);
        estoqueController.inserir(new Estoque(produto2, random.nextInt(100)));

        // Produto 3
        Produto produto3 = new Produto("Hamburguer", "sanduíche de carne bovina", "HAMBURGER", 8.50, 12.00, TipoProduto.CARNES);
        produtoController.inserir(produto3);
        estoqueController.inserir(new Estoque(produto3, random.nextInt(100)));

        // Produto 4
        Produto produto4 = new Produto("Salada Caesar", "salada com mix de folhas verdes", "SALADAC", 6.00, 10.00, TipoProduto.SALADAS);
        produtoController.inserir(produto4);
        estoqueController.inserir(new Estoque(produto4, random.nextInt(100)));

        // Produto 5
        Produto produto5 = new Produto("Sopa de Legumes", "sopa cremosa de legumes", "SOPALEG", 4.50, 8.00, TipoProduto.SOPAS);
        produtoController.inserir(produto5);
        estoqueController.inserir(new Estoque(produto5, random.nextInt(100)));

        // Produto 6
        Produto produto6 = new Produto("Sobremesa de Chocolate", "bolo de chocolate", "SOBREM", 5.50, 9.00, TipoProduto.SOBREMESAS);
        produtoController.inserir(produto6);
        estoqueController.inserir(new Estoque(produto6, random.nextInt(100)));

        // Produto 7
        Produto produto7 = new Produto("Refrigerante Guaraná 2L", "refrigerante sabor guaraná", "GUARA2L", 5.00, 8.50, TipoProduto.BEBIDAS);
        produtoController.inserir(produto7);
        estoqueController.inserir(new Estoque(produto7, random.nextInt(100)));

        // Produto 8
        Produto produto8 = new Produto("Frango Assado", "frango assado e temperado", "FRANGO", 12.50, 20.00, TipoProduto.CARNES);
        produtoController.inserir(produto8);
        estoqueController.inserir(new Estoque(produto8, random.nextInt(100)));

        // Produto 9
        Produto produto9 = new Produto("Salada de Frutas", "mix de frutas frescas", "SALADAFR", 7.00, 12.00, TipoProduto.SALADAS);
        produtoController.inserir(produto9);
        estoqueController.inserir(new Estoque(produto9, random.nextInt(100)));

        // Produto 10
        Produto produto10 = new Produto("Sopa de Cebola", "sopa de cebola gratinada", "SOPACEB", 5.50, 9.00, TipoProduto.SOPAS);
        produtoController.inserir(produto10);
        estoqueController.inserir(new Estoque(produto10, random.nextInt(100)));

        // Produto 11
        Produto produto11 = new Produto("Pudim de Leite", "pudim de leite condensado", "PUDIM", 6.50, 11.00, TipoProduto.SOBREMESAS);
        produtoController.inserir(produto11);
        estoqueController.inserir(new Estoque(produto11, random.nextInt(100)));

        // Produto 12
        Produto produto12 = new Produto("Suco de Laranja 1L", "suco natural de laranja", "SUCOLAR1L", 4.50, 7.50, TipoProduto.BEBIDAS);
        produtoController.inserir(produto12);
        estoqueController.inserir(new Estoque(produto12, random.nextInt(100)));

        // Produto 13
        Produto produto13 = new Produto("Costela de Porco", "costela suína assada", "COSTPORC", 15.00, 25.00, TipoProduto.CARNES);
        produtoController.inserir(produto13);
        estoqueController.inserir(new Estoque(produto13, random.nextInt(100)));

        // Produto 14
        Produto produto14 = new Produto("Salada Caprese", "salada com tomate, mussarela de búfala e manjericão", "SALADCAP", 8.00, 14.00, TipoProduto.SALADAS);
        produtoController.inserir(produto14);
        estoqueController.inserir(new Estoque(produto14, random.nextInt(100)));

        // Produto 15
        Produto produto15 = new Produto("Sopa de Feijão", "sopa cremosa de feijão", "SOPAFEI", 5.00, 9.00, TipoProduto.SOPAS);
        produtoController.inserir(produto15);
        estoqueController.inserir(new Estoque(produto15, random.nextInt(100)));

        // Produto 16
        Produto produto16 = new Produto("Mousse de Maracujá", "mousse de maracujá com cobertura de chocolate", "MOUSSEMAR", 6.50, 11.00, TipoProduto.SOBREMESAS);
        produtoController.inserir(produto16);
        estoqueController.inserir(new Estoque(produto16, random.nextInt(100)));

         // Produto 17
         Produto produto17 = new Produto("Chá Gelado de Limão 500ml", "chá gelado sabor limão", "CHAGEL500", 3.50, 6.00, TipoProduto.BEBIDAS);
         produtoController.inserir(produto17);
         estoqueController.inserir(new Estoque(produto17, random.nextInt(100)));
 
         // Produto 18
         Produto produto18 = new Produto("Bife à Parmegiana", "bife empanado com queijo e molho de tomate", "BIFEPARM", 10.00, 18.00, TipoProduto.CARNES);
         produtoController.inserir(produto18);
         estoqueController.inserir(new Estoque(produto18, random.nextInt(100)));
 
         // Produto 19
         Produto produto19 = new Produto("Salada de Grãos", "salada com grãos diversos e vinagrete", "SALADGRAO", 7.50, 13.00, TipoProduto.SALADAS);
         produtoController.inserir(produto19);
         estoqueController.inserir(new Estoque(produto19, random.nextInt(100)));
 
         // Produto 20
         Produto produto20 = new Produto("Sopa de Abóbora", "sopa cremosa de abóbora", "SOPABOB", 4.50, 8.00, TipoProduto.SOPAS);
         produtoController.inserir(produto20);
         estoqueController.inserir(new Estoque(produto20, random.nextInt(100)));
 
         // Produto 21
         Produto produto21 = new Produto("Cheesecake de Morango", "cheesecake com cobertura de morango", "CHEESEMOR", 7.50, 13.00, TipoProduto.SOBREMESAS);
         produtoController.inserir(produto21);
         estoqueController.inserir(new Estoque(produto21, random.nextInt(100)));

         // Produto 22
        Produto produto22 = new Produto("Suco de Uva Integral 1L", "suco de uva natural integral", "SUCOUVA1L", 5.50, 9.50, TipoProduto.BEBIDAS);
        produtoController.inserir(produto22);
        estoqueController.inserir(new Estoque(produto22, random.nextInt(100)));

        // Produto 23
        Produto produto23 = new Produto("Picanha", "picanha bovina grelhada", "PICANHA", 20.00, 35.00, TipoProduto.CARNES);
        produtoController.inserir(produto23);
        estoqueController.inserir(new Estoque(produto23, random.nextInt(100)));

        // Produto 24
        Produto produto24 = new Produto("Salada de Quinoa", "salada com quinoa, legumes e molho de iogurte", "SALADQUIN", 9.00, 16.00, TipoProduto.SALADAS);
        produtoController.inserir(produto24);
        estoqueController.inserir(new Estoque(produto24, random.nextInt(100)));

        // Produto 25
        Produto produto25 = new Produto("Sopa de Mandioquinha", "sopa cremosa de mandioquinha", "SOPAMAND", 6.00, 10.00, TipoProduto.SOPAS);
        produtoController.inserir(produto25);
        estoqueController.inserir(new Estoque(produto25, random.nextInt(100)));

        // Produto 26
        Produto produto26 = new Produto("Mousse de Limão", "mousse de limão com raspas de chocolate", "MOUSSELIM", 6.50, 11.00, TipoProduto.SOBREMESAS);
        produtoController.inserir(produto26);
        estoqueController.inserir(new Estoque(produto26, random.nextInt(100)));

        // Produto 27
        Produto produto27 = new Produto("Água de Coco 500ml", "água de coco natural", "AGUACOCO500", 4.00, 7.00, TipoProduto.BEBIDAS);
        produtoController.inserir(produto27);
        estoqueController.inserir(new Estoque(produto27, random.nextInt(100)));

        // Produto 28
        Produto produto28 = new Produto("Filé Mignon", "filé mignon grelhado", "FILEMIGNON", 18.00, 30.00, TipoProduto.CARNES);
        produtoController.inserir(produto28);
        estoqueController.inserir(new Estoque(produto28, random.nextInt(100)));

        // Produto 29
        Produto produto29 = new Produto("Salada de Cuscuz", "salada com cuscuz, vegetais e azeite de oliva", "SALADCUSCUZ", 8.50, 15.00, TipoProduto.SALADAS);
        produtoController.inserir(produto29);
        estoqueController.inserir(new Estoque(produto29, random.nextInt(100)));

        // Produto 30
        Produto produto30 = new Produto("Sopa de Ervilha", "sopa cremosa de ervilha", "SOPAERVILHA", 5.50, 9.50, TipoProduto.SOPAS);
        produtoController.inserir(produto30);
        estoqueController.inserir(new Estoque(produto30, random.nextInt(100)));

        // Produto 31
        Produto produto31 = new Produto("Cheesecake de Frutas Vermelhas", "cheesecake com cobertura de frutas vermelhas", "CHEESEFRUT", 8.50, 15.00, TipoProduto.SOBREMESAS);
        produtoController.inserir(produto31);
        estoqueController.inserir(new Estoque(produto31, random.nextInt(100)));

        // Produto 32
        Produto produto32 = new Produto("Suco de Manga 300ml", "suco natural de manga", "SUCOMANGA300", 3.50, 6.00, TipoProduto.BEBIDAS);
        produtoController.inserir(produto32);
        estoqueController.inserir(new Estoque(produto32, random.nextInt(100)));

        // Produto 33
        Produto produto33 = new Produto("Cordeiro Assado", "cordeiro assado no forno", "CORDEIRO", 25.00, 45.00, TipoProduto.CARNES);
        produtoController.inserir(produto33);
        estoqueController.inserir(new Estoque(produto33, random.nextInt(100)));

        // Produto 34
        Produto produto34 = new Produto("Salada Grega", "salada com queijo feta, tomate e azeitonas", "SALADAGREG", 9.00, 16.00, TipoProduto.SALADAS);
        produtoController.inserir(produto34);
        estoqueController.inserir(new Estoque(produto34, random.nextInt(100)));

        // Produto 35
        Produto produto35 = new Produto("Canja de Galinha", "canja de galinha tradicional", "CANJAGAL", 6.00, 10.00, TipoProduto.SOPAS);
        produtoController.inserir(produto35);
        estoqueController.inserir(new Estoque(produto35, random.nextInt(100)));

        // Produto 36
        Produto produto36 = new Produto("Tiramisu", "sobremesa italiana à base de café e queijo mascarpone", "TIRAMISU", 8.00, 14.00, TipoProduto.SOBREMESAS);
        produtoController.inserir(produto36);
        estoqueController.inserir(new Estoque(produto36, random.nextInt(100)));

        // Produto 37
        Produto produto37 = new Produto("Água Mineral 500ml", "água mineral sem gás", "AGUAMIN500", 2.50, 5.00, TipoProduto.BEBIDAS);
        produtoController.inserir(produto37);
        estoqueController.inserir(new Estoque(produto37, random.nextInt(100)));

        // Produto 38
        Produto produto38 = new Produto("Bife à Milanesa", "bife empanado e frito", "BIFEMILAN", 12.00, 22.00, TipoProduto.CARNES);
        produtoController.inserir(produto38);
        estoqueController.inserir(new Estoque(produto38, random.nextInt(100)));

        // Produto 39
        Produto produto39 = new Produto("Salada Caesar", "salada com alface, frango grelhado e molho caesar", "SALADCAESAR", 8.50, 15.00, TipoProduto.SALADAS);
        produtoController.inserir(produto39);
        estoqueController.inserir(new Estoque(produto39, random.nextInt(100)));

        // Produto 40
        Produto produto40 = new Produto("Canja de Legumes", "canja de legumes e frango", "CANJALEGUM", 5.50, 9.50, TipoProduto.SOPAS);
        produtoController.inserir(produto40);
        estoqueController.inserir(new Estoque(produto40, random.nextInt(100)));

        // Produto 41
        Produto produto41 = new Produto("Pavê de Chocolate", "sobremesa de pavê de chocolate com biscoitos", "PAVECHOCO", 7.50, 13.00, TipoProduto.SOBREMESAS);
        produtoController.inserir(produto41);
        estoqueController.inserir(new Estoque(produto41, random.nextInt(100)));

        // Produto 42
        Produto produto42 = new Produto("Refrigerante de Guarana 2L", "refrigerante de guaraná", "GUARANA2L", 5.00, 9.00, TipoProduto.BEBIDAS);
        produtoController.inserir(produto42);
        estoqueController.inserir(new Estoque(produto42, random.nextInt(100)));

        // Produto 43
        Produto produto43 = new Produto("Frango à Passarinho", "frango frito em pedaços pequenos", "FRANGPASS", 14.00, 25.00, TipoProduto.CARNES);
        produtoController.inserir(produto43);
        estoqueController.inserir(new Estoque(produto43, random.nextInt(100)));

        // Produto 44
        Produto produto44 = new Produto("Salada de Rúcula", "salada com rúcula, tomate cereja e queijo parmesão", "SALADRUCULA", 7.00, 12.00, TipoProduto.SALADAS);
        produtoController.inserir(produto44);
        estoqueController.inserir(new Estoque(produto44, random.nextInt(100)));

        // Produto 45
        Produto produto45 = new Produto("Creme de Aspargos", "creme de aspargos frescos", "CREMEASPAR", 6.00, 10.00, TipoProduto.SOPAS);
        produtoController.inserir(produto45);
        estoqueController.inserir(new Estoque(produto45, random.nextInt(100)));

        // Produto 46
        Produto produto46 = new Produto("Pudim de Leite", "pudim de leite condensado", "PUDIMLEITE", 6.50, 11.00, TipoProduto.SOBREMESAS);
        produtoController.inserir(produto46);
        estoqueController.inserir(new Estoque(produto46, random.nextInt(100)));
        
        // Produto 47
        Produto produto47 = new Produto("Suco de Laranja 1L", "suco natural de laranja", "SUCOLARANJA1L", 4.50, 8.00, TipoProduto.BEBIDAS);
        produtoController.inserir(produto47);
        estoqueController.inserir(new Estoque(produto47, random.nextInt(100)));

        // Produto 48
        Produto produto48 = new Produto("Costela de Porco", "costela de porco assada", "COSTELAPORCO", 22.00, 40.00, TipoProduto.CARNES);
        produtoController.inserir(produto48);
        estoqueController.inserir(new Estoque(produto48, random.nextInt(100)));

        // Produto 49
        Produto produto49 = new Produto("Salada de Tomate", "salada com tomates frescos, cebola e manjericão", "SALADATOMATE", 6.50, 11.00, TipoProduto.SALADAS);
        produtoController.inserir(produto49);
        estoqueController.inserir(new Estoque(produto49, random.nextInt(100)));

        // Produto 50
        Produto produto50 = new Produto("Sopa de Cebola", "sopa gratinada de cebola", "SOPACEBOLA", 5.50, 9.50, TipoProduto.SOPAS);
        produtoController.inserir(produto50);
        estoqueController.inserir(new Estoque(produto50, random.nextInt(100)));

    }

}
