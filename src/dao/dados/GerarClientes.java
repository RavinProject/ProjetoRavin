package dao.dados;

import java.util.ArrayList;
import java.util.List;

import Models.Cliente;

public class GerarClientes {

    public static List<Cliente> pegaLista() {
        List<Cliente> lista = new ArrayList<Cliente>();
        lista.add(new Cliente("Regis Amaral", "055984457560", "00333472047", "Cliente VIP", true));
        lista.add(new Cliente("João Silva", "055123456789", "01234567890", "Cliente Regular", true));
        lista.add(new Cliente("Maria Santos", "055987654321", "09876543210", "Cliente VIP", true));
        lista.add(new Cliente("Ana Oliveira", "055555555555", "00000000000", "Cliente Regular", true));
        lista.add(new Cliente("Pedro Almeida", "055777777777", "11111111111", "Cliente Regular", true));
        lista.add(new Cliente("Fernanda Costa", "055888888888", "22222222222", "Cliente VIP", true));
        lista.add(new Cliente("Lucas Souza", "055999999999", "33333333333", "Cliente Regular", true));
        lista.add(new Cliente("Carolina Santos", "055444444444", "44444444444", "Cliente VIP", true));
        lista.add(new Cliente("Marcos Oliveira", "055333333333", "55555555555", "Cliente Regular", true));
        lista.add(new Cliente("Julia Pereira", "055222222222", "66666666666", "Cliente Regular", true));
        lista.add(new Cliente("Rafael Mendes", "055666666666", "77777777777", "Cliente VIP", true));
        lista.add(new Cliente("Larissa Fernandes", "055777777777", "88888888888", "Cliente Regular", true));
        lista.add(new Cliente("Paulo Santos", "055111111111", "99999999999", "Cliente Regular", true));
        lista.add(new Cliente("Mariana Lima", "055888888888", "12345678901", "Cliente VIP", true));
        lista.add(new Cliente("Gustavo Rodrigues", "055444444444", "23456789012", "Cliente Regular", true));
        lista.add(new Cliente("Camila Castro", "055555555555", "34567890123", "Cliente VIP", true));
        lista.add(new Cliente("Bruno Carvalho", "055666666666", "45678901234", "Cliente Regular", true));
        lista.add(new Cliente("Isabela Costa", "055777777777", "56789012345", "Cliente Regular", true));
        lista.add(new Cliente("Diego Silva", "055333333333", "67890123456", "Cliente VIP", true));
        lista.add(new Cliente("Letícia Oliveira", "055222222222", "78901234567", "Cliente Regular", true));
        return lista;
    }

}
