package views.cliente;

import controllers.interfaces.IClienteController;
import models.Cliente;
import utils.DateUtils;

import java.util.Date;
import java.util.InputMismatchException;

import static views.View.exibeDialogo;
import static views.View.solicitaEntradaDeDado;
import static views.cliente.SubmenuCliente.imprimeCliente;

public class CadastrarClienteView {
    static void cadastrar(IClienteController clienteController) {
        Cliente cliente = new Cliente();
        try {
            // TODO ver se existe alguma maneira mais simples de mostrar submenus
            cliente.setNome(solicitaEntradaDeDado("Informe o nome do cliente:"));
            cliente.setTelefone(solicitaEntradaDeDado("Informe o telefone:"));
            cliente.setEndereco(solicitaEntradaDeDado("Endereço: "));
            cliente.setCpf(solicitaEntradaDeDado("Informe o CPF:"));
            cliente.setNascimento(DateUtils.stringToDate(solicitaEntradaDeDado("Data de nascimento: \nFormato: dd/mm/yyyy")));
            cliente.setObservacao(solicitaEntradaDeDado("Informe uma observação ou tecle enter para continuar:"));
            cliente.setAlergias(solicitaEntradaDeDado("Alergias: "));
            boolean vip = solicitaEntradaDeDado("VIP?\n 0 - Não \n 1 - Sim").equals("1") ? true : false;
            cliente.setVip(vip);
            cliente.setAtivo(true);
            cliente.setCriadoEm(new Date());
            cliente.setCriadoPor(null);
            cliente.setAlteradoEm(new Date());
            cliente.setAlteradoPor(null);
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
