package views;

import java.util.Date;
import java.util.Scanner;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.enuns.EstadoCivil;
import dao.enuns.TipoProduto;

import java.awt.GridLayout;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;

import models.Cliente;
import models.Comanda;
import models.Estoque;
import models.Funcionario;
import models.Mesa;
import models.Pedido;
import models.Produto;
import views.menus.PrincipalMenu;

public class Cadastro extends View {

    private static Scanner scanner;
    private static Cliente cliente;
    private static Funcionario funcionario;
    private static Produto produto;
    private static Estoque estoque;
    private static Pedido pedido;
    private static Comanda comanda;
    private static Mesa mesa;

    private static String formato = "dd/MM/yyyy";
    private static DateFormat dateFormat = new SimpleDateFormat(formato);

    public static void menu() {
        boolean exec = true;
        while (exec) {
            String opcao = selecionarOpcao(PrincipalMenu.inicial());
            System.out.println(opcao + " selecionado");
            switch (opcao) {
                case "1":
                    cadastrarCliente();
                    break;
                case "2":
                    cadastrarFuncionario();
                    break;
                case "3":
                    cadastrarProduto();
                    break;
                case "4":
                    cadastrarEstoque();
                    break;
                case "5":
                    cadastrarPedido();
                    break;
                case "6":
                    cadastrarComanda();
                    break;
                case "7":
                    cadastrarMesa();
                    break;
                case "x":
                    exec = false;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    public static void cadastrarCliente() {
        try {
            cliente = new Cliente();
            cliente.setId(0);
            System.out.println("Informe o nome:");
            cliente.setNome(scanner.nextLine());
            System.out.println("Informe o telefone:");
            cliente.setTelefone(scanner.nextLine());
            System.out.println("Informe o endereço:");
            cliente.setEndereco(scanner.nextLine());
            System.out.println("Informe o CPF:");
            cliente.setCpf(scanner.nextLine());
            System.out.println("Informe a data de nascimento no formato dd/mm/yyyy:");
            cliente.setNascimento(dateFormat.parse(scanner.nextLine()));
            System.out.println("Informe uma observação ou tecle enter");
            cliente.setObservacao(scanner.nextLine());
            System.out.println("Informe a informação sobre alergia ou tecle enter:");
            cliente.setAlergias(scanner.nextLine());
            System.out.println("O cleinte é vip? [1] Sim [0] Não");
            cliente.setVip(scanner.nextLine().equals("1") ? true : false);
            cliente.setAtivo(true);
            cliente.setCriadoEm(new Date());
            cliente.setCriadoPor(null);
            cliente.setAlteradoEm(new Date());
            cliente.setAlteradoPor(null);
            System.out.println("O cliente " + cliente.getNome() + " foi inserido com sucesso!\n");
            System.out.println("Pressione enter para continuar...");
            scanner.nextLine();
        } catch (ParseException e) {
            System.out.println("Erro na conversão da data.");
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Opção inálida para o Estado Civil");
        }
    }

    public static void cadastrarFuncionario() {
        try {
            funcionario = new Funcionario();
            funcionario.setId(1);
            System.out.println("Informe o nome:");
            funcionario.setNome(scanner.nextLine());
            System.out.println("Informe o telefone:");
            funcionario.setTelefone(scanner.nextLine());
            System.out.println("Informe o endereço:");
            funcionario.setEndereco(scanner.nextLine());
            System.out.println("Informe o CPF:");
            funcionario.setCpf(scanner.nextLine());
            System.out.println("Informe a data de nascimento no formato dd/mm/yyyy:");
            funcionario.setNascimento(dateFormat.parse(scanner.nextLine()));
            System.out.println("Informe uma observação ou tecle enter");
            funcionario.setObservacao(scanner.nextLine());
            System.out.println("Informe o RG");
            funcionario.setRg(scanner.nextLine());
            System.out.println("Selecione o estado civil");
            System.out.println("[1] Solteiro");
            System.out.println("[2] Casado");
            System.out.println("[3] Separado");
            System.out.println("[4] Divorciado");
            System.out.println("[5] Viúvo");
            funcionario.setEstadoCivil(EstadoCivil.values()[Integer.parseInt(scanner.nextLine()) - 1]);
            funcionario.setAtivo(true);
            funcionario.setCriadoEm(new Date());
            funcionario.setCriadoPor(null);
            funcionario.setAlteradoEm(new Date());
            funcionario.setAlteradoPor(null);
            System.out.println("O funcionario " + funcionario.getNome() + " foi inserido com sucesso!\n");
            System.out.println("Pressione enter para continuar...");
            scanner.nextLine();
        } catch (ParseException e) {
            System.out.println("Erro na conversão da data.");
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Opção inválida para o Estado Civil");
        }
    }

    public static void cadastrarProduto() {
        try{
            produto = new Produto();
            produto.setId(0);
            System.out.println("Informe o nome:");
            produto.setNome(scanner.nextLine());
            System.out.println("Informe uma descrição ou tecle enter:");
            produto.setDescricao(scanner.nextLine());
            System.out.println("Informe um código para o produto:");
            produto.setCodigo(scanner.nextLine());
            System.out.println("Informe o preço de custo (1,99):");
            produto.setPrecoCusto(scanner.nextDouble());
            System.out.println("Informe o preço de venda (1,99):");
            produto.setPrecoVenda(scanner.nextDouble());
            scanner.nextLine();
            System.out.println("Informe o tempo de preparo: hh:mm");
            produto.setTempoPreparo(scanner.nextLine());
            System.out.println("Informe uma observação ou tecle enter");
            produto.setObservacoes(scanner.nextLine());
            System.out.println("Selecione o tipo do produto:");
            System.out.println("[1] Bebidas");
            System.out.println("[2] Carnes");
            System.out.println("[3] Saladas");
            System.out.println("[4] Sopas");
            System.out.println("[5] Sobremesas");
            produto.setTipoProduto(TipoProduto.values()[Integer.parseInt(scanner.nextLine()) - 1]);
            produto.setAtivo(true);
            produto.setCriadoEm(new Date());
            produto.setCriadoPor(null);
            produto.setAlteradoEm(new Date());
            produto.setAlteradoPor(null);
            System.out.println("O produto " + produto.getNome() + " foi inserido com sucesso!\n");
            System.out.println("Pressione enter para continuar...");
            scanner.nextLine();
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Opção inválida para o Estado Civil");
        }
    }

    public static void cadastrarEstoque() {
        if(produto == null){
            System.out.println("Você precisa cadastrar o produto primeiro!");
        }
        estoque = new Estoque();
        estoque.setProduto(produto);
        System.out.println("Informe a quantidade do produto " + produto.getNome() + ":");
        estoque.setQuantidade(scanner.nextDouble());
        produto.setCriadoEm(new Date());
        produto.setCriadoPor(null);
        produto.setAlteradoEm(new Date());
        produto.setAlteradoPor(null);
        scanner.nextLine();
        System.out.println("Pressione enter para continuar...");
        scanner.nextLine();
    }

    public static void cadastrarPedido() {
        
    }

    public static void cadastrarComanda() {

    }

    public static void cadastrarMesa() {

    }
}
