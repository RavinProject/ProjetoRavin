package org.ravin.views.cliente;

import org.ravin.controllers.interfaces.IClienteController;
import org.ravin.models.Cliente;
import org.ravin.utils.DateUtils;

import java.util.Date;

import static org.ravin.views.View.exibeDialogo;
import static org.ravin.views.View.solicitaEntradaDeDado;
import static org.ravin.views.cliente.SubmenuCliente.imprimeCliente;

public class AtualizarClienteView {
    static void atualizar(IClienteController clienteController) {

        try {
            String cpf = solicitaEntradaDeDado("Informe o CPF do cliente que deseja alterar:");
            if (cpf == null) return;
            Cliente cliente = clienteController.recuperarPorCpf(cpf);

            if (cliente != null) {
                cliente.setNome(solicitaEntradaDeDado("Nome:", cliente.getNome()));
                cliente.setTelefone(solicitaEntradaDeDado("Telefone:", cliente.getTelefone()));
                cliente.setEndereco(solicitaEntradaDeDado("Endereço: ", cliente.getEndereco()));
                cliente.setCpf(solicitaEntradaDeDado("CPF:", cliente.getCpf()));
                cliente.setNascimento(DateUtils.stringToDate(solicitaEntradaDeDado("Data de nascimento: \nFormato: dd/mm/yyyy", DateUtils.dateToString(cliente.getNascimento()))));
                cliente.setObservacao(solicitaEntradaDeDado("Observação", cliente.getObservacao()));
                cliente.setAlergias(solicitaEntradaDeDado("Alergias: ", cliente.getAlergias()));
                boolean vip = solicitaEntradaDeDado("VIP?\n 0 - Não \n 1 - Sim", cliente.isVip() ? "1" : "0").equals("1") ? true : false;
                cliente.setVip(vip);
                boolean ativo = solicitaEntradaDeDado("Ativo?\n 0 - Não \n 1 - Sim", cliente.getAtivo() ? "1" : "0").equals("1") ? true : false;
                cliente.setStatusAtivo(ativo);
                cliente.setAlteradoEm(new Date());
                cliente.setAlteradoPor(null);
                clienteController.atualizar(cliente);
                exibeDialogo("Cliente atualizado com sucesso!");
                imprimeCliente(clienteController.recuperarPorCpf(cliente.getCpf()));
            } else {
                exibeDialogo("Cliente não encontrado!");
            }
        } catch (Exception e) {
            exibeDialogo("Dado informado inválido!\nCadastro não finalizado...");
            e.printStackTrace();
        }
    }
}
