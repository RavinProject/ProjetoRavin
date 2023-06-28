package dao.dados;

import java.util.List;

import controllers.PessoaController;
import models.Cliente;
import models.Pessoa;

public class GerarClientes {

    public static void montaLista() {
        PessoaController pessoaController = new PessoaController();
        pessoaController.inserir(new Cliente("Daniele Felicio", "04798456233", "003665782047", true));
        pessoaController.inserir(new Cliente("Regis Amaral", "055984457560", "00333472048", true));
        pessoaController.inserir(new Cliente("João Silva", "055123456789", "01234567890", false));
        pessoaController.inserir(new Cliente("Maria Santos", "055987654321", "09876543210", true));
        pessoaController.inserir(new Cliente("Ana Oliveira", "055555555555", "00000000000", true));
        pessoaController.inserir(new Cliente("Pedro Almeida", "055777777777", "11111111111", true));
        pessoaController.inserir(new Cliente("Fernanda Costa", "055888888888", "22222222222", true));
        pessoaController.inserir(new Cliente("Lucas Souza", "055999999999", "33333333333", true));
        pessoaController.inserir(new Cliente("Carolina Santos", "055444444444", "44444444444", false));
        pessoaController.inserir(new Cliente("Marcos Oliveira", "055333333333", "55555555555", true));
        pessoaController.inserir(new Cliente("Julia Pereira", "055222222222", "66666666666", true));
        pessoaController.inserir(new Cliente("Rafael Mendes", "055666666666", "77777777777", true));
        pessoaController.inserir(new Cliente("Larissa Fernandes", "055777777777", "88888888888", true));
        pessoaController.inserir(new Cliente("Paulo Santos", "055111111111", "99999999999", true));
        pessoaController.inserir(new Cliente("Mariana Lima", "055888888888", "12345678901", true));
        pessoaController.inserir(new Cliente("Gustavo Rodrigues", "055444444444", "23456789012", true));
        pessoaController.inserir(new Cliente("Camila Castro", "055555555555", "34567890123", false));
        pessoaController.inserir(new Cliente("Bruno Carvalho", "055666666666", "45678901234", true));
        pessoaController.inserir(new Cliente("Isabela Costa", "055777777777", "56789012345", true));
        pessoaController.inserir(new Cliente("Diego Silva", "055333333333", "67890123456", true));
        pessoaController.inserir(new Cliente("Letícia Oliveira", "055222222222", "78901234567", true));
    }

}
