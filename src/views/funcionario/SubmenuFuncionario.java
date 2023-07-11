package views.funcionario;

import models.Cliente;
import utils.DateUtils;

public class SubmenuFuncionario {
    

      static void imprimeFuncionario(Cliente cliente) {
        String clienteDados = "ID: " + cliente.getId() +
                "\nNome: " + cliente.getNome() +
                "\nTelefone: " + cliente.getTelefone() +
                "\nEndereço: " + cliente.getEndereco() +
                "\nCPF: " + cliente.getCpf() +
                "\nNascimento: " + DateUtils.dateToString(cliente.getNascimento()) +
                "\nObservação: " + cliente.getObservacao() +
                "\nAtivo: " + (cliente.getAtivo() ? "Sim" : "Não") +
                "\nAlergia: " + cliente.getAlergias() +
                "\nVIP: " + (cliente.isVip() ? "Sim" : "Não");
        exibeDialogo(clienteDados);
    }
}

