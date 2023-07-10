package dao.dados;

import models.Cliente;

import java.util.ArrayList;
import java.util.List;

public class GerarClientes {

    public static List<Cliente> montaLista() {
        List<Cliente> listaClientes = new ArrayList<>();

        listaClientes.add(new Cliente("Daniele Felicio", "04798456233", "003665782047", true));
        listaClientes.add(new Cliente("Regis Amaral", "055984457560", "00333472048", true));
        listaClientes.add(new Cliente("João Silva", "055123456789", "01234567890", false));
        listaClientes.add(new Cliente("Maria Santos", "055987654321", "09876543210", true));
        listaClientes.add(new Cliente("Ana Oliveira", "055555555555", "00000000000", true));
        listaClientes.add(new Cliente("Pedro Almeida", "055777777777", "11111111111", true));
        listaClientes.add(new Cliente("Fernanda Costa", "055888888888", "22222222222", true));
        listaClientes.add(new Cliente("Lucas Souza", "055999999999", "33333333333", true));
        listaClientes.add(new Cliente("Carolina Santos", "055444444444", "44444444444", false));
        listaClientes.add(new Cliente("Marcos Oliveira", "055333333333", "55555555555", true));
        listaClientes.add(new Cliente("Julia Pereira", "055222222222", "66666666666", true));
        listaClientes.add(new Cliente("Rafael Mendes", "055666666666", "77777777777", true));
        listaClientes.add(new Cliente("Larissa Fernandes", "055777777777", "88888888888", true));
        listaClientes.add(new Cliente("Paulo Santos", "055111111111", "99999999999", true));
        listaClientes.add(new Cliente("Mariana Lima", "055888888888", "12345678901", true));
        listaClientes.add(new Cliente("Gustavo Rodrigues", "055444444444", "23456789012", true));
        listaClientes.add(new Cliente("Camila Castro", "055555555555", "34567890123", false));
        listaClientes.add(new Cliente("Bruno Carvalho", "055666666666", "45678901234", true));
        listaClientes.add(new Cliente("Isabela Costa", "055777777777", "56789012345", true));
        listaClientes.add(new Cliente("Diego Silva", "055333333333", "67890123456", true));
        listaClientes.add(new Cliente("Letícia Oliveira", "055222222222", "78901234567", true));

        return listaClientes;
    }

}
