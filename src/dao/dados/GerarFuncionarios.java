package dao.dados;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import models.Cargo;
import models.Funcionario;

public class GerarFuncionarios {
    public static List<Funcionario> pegaLista() {
        List<Funcionario> lista = new ArrayList<Funcionario>();
        List<Cargo> listaCargos = GerarCargos.pegaLista();
        lista.add(new Funcionario(1, "João Silva", "055123456789", "01234567890", "Ensino Médio", "CTPS123", new Date(), listaCargos.get(2)));
        lista.add(new Funcionario(2, "Maria Santos", "055987654321", "09876543210", "Ensino Superior", "CTPS456", new Date(), listaCargos.get(5)));
        lista.add(new Funcionario(3, "Ana Oliveira", "055555555555", "00000000000", "Ensino Fundamental", "CTPS789", new Date(), listaCargos.get(2)));
        lista.add(new Funcionario(4, "Pedro Almeida", "055777777777", "11111111111", "Ensino Médio", "CTPS012", new Date(), listaCargos.get(7)));
        lista.add(new Funcionario(5, "Fernanda Costa", "055888888888", "22222222222", "Ensino Superior", "CTPS345", new Date(), listaCargos.get(7)));
        lista.add(new Funcionario(6, "Lucas Souza", "055999999999", "33333333333", "Ensino Médio", "CTPS678", new Date(), listaCargos.get(1)));
        lista.add(new Funcionario(7, "Carolina Santos", "055444444444", "44444444444", "Ensino Médio", "CTPS901", new Date(), listaCargos.get(7)));
        lista.add(new Funcionario(8, "Marcos Oliveira", "055333333333", "55555555555", "Ensino Fundamental", "CTPS234", new Date(), listaCargos.get(4)));
        lista.add(new Funcionario(9, "Julia Pereira", "055222222222", "66666666666", "Ensino Médio", "CTPS567", new Date(), listaCargos.get(4)));
        lista.add(new Funcionario(10, "Rafael Mendes", "055666666666", "77777777777", "Ensino Superior", "CTPS890", new Date(), listaCargos.get(6)));
        lista.add(new Funcionario(11, "Larissa Fernandes", "055777777777", "88888888888", "Ensino Médio", "CTPS123", new Date(), listaCargos.get(4)));
        lista.add(new Funcionario(12, "Paulo Santos", "055111111111", "99999999999", "Ensino Médio", "CTPS456", new Date(), listaCargos.get(1)));
        lista.add(new Funcionario(13, "Mariana Lima", "055888888888", "12345678901", "Ensino Superior", "CTPS789", new Date(), listaCargos.get(3)));
        lista.add(new Funcionario(14, "Gustavo Rodrigues", "055444444444", "23456789012", "Ensino Médio", "CTPS012", new Date(), listaCargos.get(4)));
        lista.add(new Funcionario(15, "Camila Castro", "055555555555", "34567890123", "Ensino Médio", "CTPS345", new Date(), listaCargos.get(7)));
        lista.add(new Funcionario(16, "Bruno Carvalho", "055666666666", "45678901234", "Ensino Superior", "CTPS678", new Date(), listaCargos.get(3)));
        lista.add(new Funcionario(17, "Isabela Costa", "055777777777", "56789012345", "Ensino Médio", "CTPS901", new Date(), listaCargos.get(4)));
        lista.add(new Funcionario(18, "Diego Silva", "055333333333", "67890123456", "Ensino Médio", "CTPS234", new Date(), listaCargos.get(7)));
        lista.add(new Funcionario(19, "Letícia Oliveira", "055222222222", "78901234567", "Ensino Superior", "CTPS567", new Date(), listaCargos.get(3)));
        lista.add(new Funcionario(20, "Renata Santos", "055111111111", "89012345678", "Ensino Médio", "CTPS890", new Date(), listaCargos.get(4)));
        return lista;
    }
}
