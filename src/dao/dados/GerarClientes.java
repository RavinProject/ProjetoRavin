package dao.dados;

import java.util.ArrayList;
import java.util.List;

import models.Cliente;

public class GerarClientes {

    public static List<Cliente> pegaLista() {
        List<Cliente> lista = new ArrayList<Cliente>();
        lista.add(new Cliente(0, "Daniele Felicio", "04798456233", "003665782047", true));
        lista.add(new Cliente(1, "Regis Amaral", "055984457560", "00333472048", true));
        lista.add(new Cliente(2, "João Silva", "055123456789", "01234567890", false));
        lista.add(new Cliente(3, "Maria Santos", "055987654321", "09876543210", true));
        lista.add(new Cliente(4, "Ana Oliveira", "055555555555", "00000000000", true));
        lista.add(new Cliente(5, "Pedro Almeida", "055777777777", "11111111111", true));
        lista.add(new Cliente(6, "Fernanda Costa", "055888888888", "22222222222", true));
        lista.add(new Cliente(7, "Lucas Souza", "055999999999", "33333333333", true));
        lista.add(new Cliente(8, "Carolina Santos", "055444444444", "44444444444", false));
        lista.add(new Cliente(9, "Marcos Oliveira", "055333333333", "55555555555", true));
        lista.add(new Cliente(10, "Julia Pereira", "055222222222", "66666666666", true));
        lista.add(new Cliente(11, "Rafael Mendes", "055666666666", "77777777777", true));
        lista.add(new Cliente(12, "Larissa Fernandes", "055777777777", "88888888888", true));
        lista.add(new Cliente(13, "Paulo Santos", "055111111111", "99999999999", true));
        lista.add(new Cliente(14, "Mariana Lima", "055888888888", "12345678901", true));
        lista.add(new Cliente(15, "Gustavo Rodrigues", "055444444444", "23456789012", true));
        lista.add(new Cliente(16, "Camila Castro", "055555555555", "34567890123", false));
        lista.add(new Cliente(17, "Bruno Carvalho", "055666666666", "45678901234", true));
        lista.add(new Cliente(18, "Isabela Costa", "055777777777", "56789012345", true));
        lista.add(new Cliente(19, "Diego Silva", "055333333333", "67890123456", true));
        lista.add(new Cliente(20, "Letícia Oliveira", "055222222222", "78901234567", true));
        return lista;
    }

}
