package org.ravin.dao.dados;

import org.ravin.models.Cliente;

import java.util.ArrayList;
import java.util.List;

public class GerarClientes {

    public static List<Cliente> montaLista() {
        List<Cliente> listaClientes = new ArrayList<>();

        listaClientes.add(new Cliente(1, "Daniele Felicio", "04798456233", "003665782047", true));
        listaClientes.add(new Cliente(2, "Regis Amaral", "055984457560", "00333472048", true));
        listaClientes.add(new Cliente(3, "João Silva", "055123456789", "01234567890", false));
        listaClientes.add(new Cliente(4, "Maria Santos", "055987654321", "09876543210", true));
        listaClientes.add(new Cliente(5, "Ana Oliveira", "055555555555", "00000000000", true));
        listaClientes.add(new Cliente(6, "Pedro Almeida", "055777777777", "11111111111", true));
        listaClientes.add(new Cliente(7, "Fernanda Costa", "055888888888", "22222222222", true));
        listaClientes.add(new Cliente(8, "Lucas Souza", "055999999999", "33333333333", true));
        listaClientes.add(new Cliente(9, "Carolina Santos", "055444444444", "44444444444", false));
        listaClientes.add(new Cliente(10, "Marcos Oliveira", "055333333333", "55555555555", true));
        listaClientes.add(new Cliente(11, "Julia Pereira", "055222222222", "66666666666", true));
        listaClientes.add(new Cliente(12, "Rafael Mendes", "055666666666", "77777777777", true));
        listaClientes.add(new Cliente(13, "Larissa Fernandes", "055777777777", "88888888888", true));
        listaClientes.add(new Cliente(14, "Paulo Santos", "055111111111", "99999999999", true));
        listaClientes.add(new Cliente(15, "Mariana Lima", "055888888888", "12345678901", true));
        listaClientes.add(new Cliente(16, "Gustavo Rodrigues", "055444444444", "23456789012", true));
        listaClientes.add(new Cliente(17, "Camila Castro", "055555555555", "34567890123", false));
        listaClientes.add(new Cliente(18, "Bruno Carvalho", "055666666666", "45678901234", true));
        listaClientes.add(new Cliente(19, "Isabela Costa", "055777777777", "56789012345", true));
        listaClientes.add(new Cliente(20, "Diego Silva", "055333333333", "67890123456", true));
        listaClientes.add(new Cliente(21, "Letícia Oliveira", "055222222222", "78901234567", true));

        return listaClientes;
    }

}
