package org.backend.dao.dados;


import models.Funcionario;
import utils.enums.Cargo;
import utils.enums.Escolaridade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GerarFuncionarios {

    public static List<Funcionario> montaLista() {

        List<Funcionario> listaFuncionarios = new ArrayList<>();

        listaFuncionarios.add(new Funcionario(1, "João Silva", "055123456789", "01234567890", Escolaridade.MEDIO, "CTPS123", new Date(), Cargo.AUXILARCOZINHA, true));
        listaFuncionarios.add(new Funcionario(2, "Maria Santos", "055987654321", "09876543210", Escolaridade.SUPERIOR, "CTPS456", new Date(), Cargo.CHEFF, true));
        listaFuncionarios.add(new Funcionario(3, "Ana Oliveira", "055555555555", "00000000000", Escolaridade.FUNDAMENTAL, "CTPS789", new Date(), Cargo.BALCONISTA, true));
        listaFuncionarios.add(new Funcionario(4, "Pedro Almeida", "055777777777", "11111111111", Escolaridade.MEDIO, "CTPS012", new Date(), Cargo.BARTENDER, true));
        listaFuncionarios.add(new Funcionario(5, "Fernanda Costa", "055888888888", "22222222222", Escolaridade.SUPERIOR, "CTPS345", new Date(), Cargo.CHEFF, true));
        listaFuncionarios.add(new Funcionario(6, "Lucas Souza", "055999999999", "33333333333", Escolaridade.MEDIO, "CTPS678", new Date(), Cargo.AUXILARCOZINHA, true));
        listaFuncionarios.add(new Funcionario(7, "Carolina Santos", "055444444444", "44444444444", Escolaridade.MEDIO, "CTPS901", new Date(), Cargo.RECEPCIONISTA, true));
        listaFuncionarios.add(new Funcionario(8, "Marcos Oliveira", "055333333333", "55555555555", Escolaridade.FUNDAMENTAL, "CTPS234", new Date(), Cargo.GARCON, true));
        listaFuncionarios.add(new Funcionario(9, "Julia Pereira", "055222222222", "66666666666", Escolaridade.MEDIO, "CTPS567", new Date(), Cargo.GARCON, true));
        listaFuncionarios.add(new Funcionario(10, "Rafael Mendes", "055666666666", "77777777777", Escolaridade.SUPERIOR, "CTPS890", new Date(), Cargo.GERENTE, true));
        listaFuncionarios.add(new Funcionario(11, "Larissa Fernandes", "055777777777", "88888888888", Escolaridade.MEDIO, "CTPS123", new Date(), Cargo.GARCON, true));
        listaFuncionarios.add(new Funcionario(12, "Paulo Santos", "055111111111", "99999999999", Escolaridade.MEDIO, "CTPS456", new Date(), Cargo.AUXILARCOZINHA, true));
        listaFuncionarios.add(new Funcionario(13, "Mariana Lima", "055888888888", "12345678901", Escolaridade.SUPERIOR, "CTPS789", new Date(), Cargo.GARCON, true));
        listaFuncionarios.add(new Funcionario(14, "Gustavo Rodrigues", "055444444444", "23456789012", Escolaridade.MEDIO, "CTPS012", new Date(), Cargo.CHEFF, true));
        listaFuncionarios.add(new Funcionario(15, "Camila Castro", "055555555555", "34567890123", Escolaridade.MEDIO, "CTPS345", new Date(), Cargo.RECEPCIONISTA, true));
        listaFuncionarios.add(new Funcionario(16, "Bruno Carvalho", "055666666666", "45678901234", Escolaridade.SUPERIOR, "CTPS678", new Date(), Cargo.CHEFF, true));
        listaFuncionarios.add(new Funcionario(17, "Isabela Costa", "055777777777", "56789012345", Escolaridade.MEDIO, "CTPS901", new Date(), Cargo.GARCON, true));
        listaFuncionarios.add(new Funcionario(18, "Diego Silva", "055333333333", "67890123456", Escolaridade.MEDIO, "CTPS234", new Date(), Cargo.RECEPCIONISTA, true));
        listaFuncionarios.add(new Funcionario(10, "Letícia Oliveira", "055222222222", "78901234567", Escolaridade.SUPERIOR, "CTPS567", new Date(), Cargo.GARCON, true));
        listaFuncionarios.add(new Funcionario(20, "Renata Santos", "055111111111", "89012345678", Escolaridade.MEDIO, "CTPS890", new Date(), Cargo.GARCON, true));

        return listaFuncionarios;
    }
}
