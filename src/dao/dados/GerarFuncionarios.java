package dao.dados;


import java.util.Date;

import controllers.PessoaController;
import dao.enuns.Cargo;
import dao.enuns.Escolaridade;
import models.Funcionario;

public class GerarFuncionarios {

    public static void montaLista() {
        PessoaController pessoaController = new PessoaController();
        pessoaController.inserir(new Funcionario("João Silva", "055123456789", "01234567890", Escolaridade.MEDIO, "CTPS123", new Date(), Cargo.AUXILARCOZINHA, true));
        pessoaController.inserir(new Funcionario("Maria Santos", "055987654321", "09876543210", Escolaridade.SUPERIOR, "CTPS456", new Date(), Cargo.CHEFF, true));
        pessoaController.inserir(new Funcionario("Ana Oliveira", "055555555555", "00000000000", Escolaridade.FUNDAMENTAL, "CTPS789", new Date(), Cargo.BALCONISTA, true));
        pessoaController.inserir(new Funcionario("Pedro Almeida", "055777777777", "11111111111", Escolaridade.MEDIO, "CTPS012", new Date(), Cargo.BARTENDER, true));
        pessoaController.inserir(new Funcionario("Fernanda Costa", "055888888888", "22222222222", Escolaridade.SUPERIOR, "CTPS345", new Date(), Cargo.CHEFF, true));
        pessoaController.inserir(new Funcionario("Lucas Souza", "055999999999", "33333333333", Escolaridade.MEDIO, "CTPS678", new Date(), Cargo.AUXILARCOZINHA, true));
        pessoaController.inserir(new Funcionario("Carolina Santos", "055444444444", "44444444444", Escolaridade.MEDIO, "CTPS901", new Date(), Cargo.RECEPCIONISTA, true));
        pessoaController.inserir(new Funcionario("Marcos Oliveira", "055333333333", "55555555555", Escolaridade.FUNDAMENTAL, "CTPS234", new Date(), Cargo.GARCON, true));
        pessoaController.inserir(new Funcionario("Julia Pereira", "055222222222", "66666666666", Escolaridade.MEDIO, "CTPS567", new Date(), Cargo.GARCON, true));
        pessoaController.inserir(new Funcionario("Rafael Mendes", "055666666666", "77777777777", Escolaridade.SUPERIOR, "CTPS890", new Date(), Cargo.GERENTE, true));
        pessoaController.inserir(new Funcionario("Larissa Fernandes", "055777777777", "88888888888", Escolaridade.MEDIO, "CTPS123", new Date(), Cargo.GARCON, true));
        pessoaController.inserir(new Funcionario("Paulo Santos", "055111111111", "99999999999", Escolaridade.MEDIO, "CTPS456", new Date(), Cargo.AUXILARCOZINHA, true));
        pessoaController.inserir(new Funcionario("Mariana Lima", "055888888888", "12345678901", Escolaridade.SUPERIOR, "CTPS789", new Date(), Cargo.GARCON, true));
        pessoaController.inserir(new Funcionario("Gustavo Rodrigues", "055444444444", "23456789012", Escolaridade.MEDIO, "CTPS012", new Date(), Cargo.CHEFF, true));
        pessoaController.inserir(new Funcionario("Camila Castro", "055555555555", "34567890123", Escolaridade.MEDIO, "CTPS345", new Date(), Cargo.RECEPCIONISTA, true));
        pessoaController.inserir(new Funcionario("Bruno Carvalho", "055666666666", "45678901234", Escolaridade.SUPERIOR, "CTPS678", new Date(), Cargo.CHEFF, true));
        pessoaController.inserir(new Funcionario("Isabela Costa", "055777777777", "56789012345", Escolaridade.MEDIO, "CTPS901", new Date(), Cargo.GARCON, true));
        pessoaController.inserir(new Funcionario("Diego Silva", "055333333333", "67890123456", Escolaridade.MEDIO, "CTPS234", new Date(), Cargo.RECEPCIONISTA, true));
        pessoaController.inserir(new Funcionario("Letícia Oliveira", "055222222222", "78901234567", Escolaridade.SUPERIOR, "CTPS567", new Date(), Cargo.GARCON, true));
        pessoaController.inserir(new Funcionario("Renata Santos", "055111111111", "89012345678", Escolaridade.MEDIO, "CTPS890", new Date(), Cargo.GARCON, true));
    }
}
