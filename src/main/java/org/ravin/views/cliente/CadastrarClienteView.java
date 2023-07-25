package org.ravin.views.cliente;

import org.ravin.controllers.interfaces.IClienteController;
import org.ravin.models.Cliente;
import org.ravin.utils.DateUtils;

import java.util.Date;
import java.util.InputMismatchException;

import static org.ravin.views.View.exibeDialogo;
import static org.ravin.views.View.solicitaEntradaDeDado;
import static org.ravin.views.cliente.SubmenuCliente.imprimeCliente;

public class CadastrarClienteView {
    static void cadastrar(IClienteController clienteController) {
        try {
            String nome = solicitaEntradaDeDado("Informe o nome do cliente:");
            String telefone = solicitaEntradaDeDado("Informe o telefone:");
            String endereco = solicitaEntradaDeDado("Endereço: ");
            String cpf = solicitaEntradaDeDado("Informe o CPF:");
            Date nascimento = DateUtils.stringToDate(solicitaEntradaDeDado("Data de nascimento: \nFormato: dd/mm/yyyy"));
            String observacao = solicitaEntradaDeDado("Informe uma observação ou tecle enter para continuar:");
            String alergias = solicitaEntradaDeDado("Alergias: ");
            boolean vip = solicitaEntradaDeDado("VIP?\n 0 - Não \n 1 - Sim").equals("1");
            Date agora = new Date();

            Cliente cliente = new Cliente(nome, telefone, endereco, cpf, nascimento, observacao, true, agora, agora, alergias, vip);

            clienteController.inserir(cliente);
            exibeDialogo("Cliente inserido com sucesso!");
            imprimeCliente(clienteController.recuperarPorCpf(cliente.getCpf()));
        } catch(InputMismatchException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            exibeDialogo("Um erro ocorreu!\nCadastro não finalizado...");
            e.printStackTrace();
        }
    }
}
