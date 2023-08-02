package org.ravin.dao.dados;

import org.ravin.models.Produto;
import org.ravin.utils.enums.TipoProduto;

import java.util.ArrayList;
import java.util.List;

public class GerarProdutos {
    public static List<Produto> montaLista() {
        List<Produto> produtos = new ArrayList<>();

        // Produto 1
        Produto produto1 = new Produto(1, "Coca-Cola 600ml", "refrigerante de cola", "COCA600", 3.80, 6.50, TipoProduto.BEBIDAS);
        produtos.add(produto1);

        // Produto 2
        Produto produto2 = new Produto(2, "Água Mineral 500ml", "água mineral sem gás", "AGUA500", 2.50, 4.00, TipoProduto.BEBIDAS);
        produtos.add(produto2);

        // Produto 3
        Produto produto3 = new Produto(3, "Hamburguer", "sanduíche de carne bovina", "HAMBURGER", 8.50, 12.00, TipoProduto.CARNES);
        produtos.add(produto3);

        // Produto 4
        Produto produto4 = new Produto(4, "Salada Caesar", "salada com mix de folhas verdes", "SALADAC", 6.00, 10.00, TipoProduto.SALADAS);
        produtos.add(produto4);

        // Produto 5
        Produto produto5 = new Produto(5, "Sopa de Legumes", "sopa cremosa de legumes", "SOPALEG", 4.50, 8.00, TipoProduto.SOPAS);
        produtos.add(produto5);

        // Produto 6
        Produto produto6 = new Produto(6, "Sobremesa de Chocolate", "bolo de chocolate", "SOBREM", 5.50, 9.00, TipoProduto.SOBREMESAS);
        produtos.add(produto6);

        // Produto 7
        Produto produto7 = new Produto(7, "Refrigerante Guaraná 2L", "refrigerante sabor guaraná", "GUARA2L", 5.00, 8.50, TipoProduto.BEBIDAS);
        produtos.add(produto7);

        // Produto 8
        Produto produto8 = new Produto(8, "Frango Assado", "frango assado e temperado", "FRANGO", 12.50, 20.00, TipoProduto.CARNES);
        produtos.add(produto8);

        // Produto 9
        Produto produto9 = new Produto(9, "Salada de Frutas", "mix de frutas frescas", "SALADAFR", 7.00, 12.00, TipoProduto.SALADAS);
        produtos.add(produto9);

        // Produto 10
        Produto produto10 = new Produto(10, "Sopa de Cebola", "sopa de cebola gratinada", "SOPACEB", 5.50, 9.00, TipoProduto.SOPAS);
        produtos.add(produto10);

        // Produto 11
        Produto produto11 = new Produto(11, "Pudim de Leite", "pudim de leite condensado", "PUDIM", 6.50, 11.00, TipoProduto.SOBREMESAS);
        produtos.add(produto11);

        // Produto 12
        Produto produto12 = new Produto(12, "Suco de Laranja 1L", "suco natural de laranja", "SUCOLAR1L", 4.50, 7.50, TipoProduto.BEBIDAS);
        produtos.add(produto12);

        // Produto 13
        Produto produto13 = new Produto(13, "Costela de Porco", "costela suína assada", "COSTPORC", 15.00, 25.00, TipoProduto.CARNES);
        produtos.add(produto13);

        // Produto 14
        Produto produto14 = new Produto(14, "Salada Caprese", "salada com tomate, mussarela de búfala e manjericão", "SALADCAP", 8.00, 14.00, TipoProduto.SALADAS);
        produtos.add(produto14);

        // Produto 15
        Produto produto15 = new Produto(15, "Sopa de Feijão", "sopa cremosa de feijão", "SOPAFEI", 5.00, 9.00, TipoProduto.SOPAS);
        produtos.add(produto15);

        // Produto 16
        Produto produto16 = new Produto(16, "Mousse de Maracujá", "mousse de maracujá com cobertura de chocolate", "MOUSSEMAR", 6.50, 11.00, TipoProduto.SOBREMESAS);
        produtos.add(produto16);

         // Produto 17
         Produto produto17 = new Produto(17, "Chá Gelado de Limão 500ml", "chá gelado sabor limão", "CHAGEL500", 3.50, 6.00, TipoProduto.BEBIDAS);
         produtos.add(produto17);
 
         // Produto 18
         Produto produto18 = new Produto(18, "Bife à Parmegiana", "bife empanado com queijo e molho de tomate", "BIFEPARM", 10.00, 18.00, TipoProduto.CARNES);
         produtos.add(produto18);
 
         // Produto 19
         Produto produto19 = new Produto(19, "Salada de Grãos", "salada com grãos diversos e vinagrete", "SALADGRAO", 7.50, 13.00, TipoProduto.SALADAS);
         produtos.add(produto19);
 
         // Produto 20
         Produto produto20 = new Produto(20, "Sopa de Abóbora", "sopa cremosa de abóbora", "SOPABOB", 4.50, 8.00, TipoProduto.SOPAS);
         produtos.add(produto20);
 
         // Produto 21
         Produto produto21 = new Produto(21, "Cheesecake de Morango", "cheesecake com cobertura de morango", "CHEESEMOR", 7.50, 13.00, TipoProduto.SOBREMESAS);
         produtos.add(produto21);

         // Produto 22
        Produto produto22 = new Produto(22, "Suco de Uva Integral 1L", "suco de uva natural integral", "SUCOUVA1L", 5.50, 9.50, TipoProduto.BEBIDAS);
        produtos.add(produto22);

        // Produto 23
        Produto produto23 = new Produto(23, "Picanha", "picanha bovina grelhada", "PICANHA", 20.00, 35.00, TipoProduto.CARNES);
        produtos.add(produto23);

        // Produto 24
        Produto produto24 = new Produto(24, "Salada de Quinoa", "salada com quinoa, legumes e molho de iogurte", "SALADQUIN", 9.00, 16.00, TipoProduto.SALADAS);
        produtos.add(produto24);

        // Produto 25
        Produto produto25 = new Produto(25, "Sopa de Mandioquinha", "sopa cremosa de mandioquinha", "SOPAMAND", 6.00, 10.00, TipoProduto.SOPAS);
        produtos.add(produto25);

        // Produto 26
        Produto produto26 = new Produto(26, "Mousse de Limão", "mousse de limão com raspas de chocolate", "MOUSSELIM", 6.50, 11.00, TipoProduto.SOBREMESAS);
        produtos.add(produto26);

        // Produto 27
        Produto produto27 = new Produto(27, "Água de Coco 500ml", "água de coco natural", "AGUACOCO500", 4.00, 7.00, TipoProduto.BEBIDAS);
        produtos.add(produto27);

        // Produto 28
        Produto produto28 = new Produto(28, "Filé Mignon", "filé mignon grelhado", "FILEMIGNON", 18.00, 30.00, TipoProduto.CARNES);
        produtos.add(produto28);

        // Produto 29
        Produto produto29 = new Produto(29, "Salada de Cuscuz", "salada com cuscuz, vegetais e azeite de oliva", "SALADCUSCUZ", 8.50, 15.00, TipoProduto.SALADAS);
        produtos.add(produto29);

        // Produto 30
        Produto produto30 = new Produto(30, "Sopa de Ervilha", "sopa cremosa de ervilha", "SOPAERVILHA", 5.50, 9.50, TipoProduto.SOPAS);
        produtos.add(produto30);

        return produtos;
    }

}
