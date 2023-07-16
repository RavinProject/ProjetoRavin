package views.funcionario;

import controllers.interfaces.IFuncionarioController;
import models.Funcionario;
import utils.DateUtils;

import static views.View.*;

import java.util.Date;

public class CadastrarFuncionarioView{

    static void cadastrar(IFuncionarioController funcionarioController) {
        Funcionario funcionario = new Funcionario();
        try {   
        funcionario.setNome(solicitaEntradaDeDado("Informe o nome do Funcionario "));
        funcionario.setCpf(solicitaEntradaDeDado("Informe o CPF: "));
     //   funcionario.setCargo(solicitaEntradaDeDado("Informe o Cargo"));
        funcionario.setTelefone(solicitaEntradaDeDado("Informe o telefone: "));
        funcionario.setEndereco(solicitaEntradaDeDado("Endereço: "));
        funcionario.setNascimento(DateUtils.stringToDate(solicitaEntradaDeDado("Data de nascimento: \nFormato: dd/mm/yyyy")));
        funcionario.setPis(solicitaEntradaDeDado("Informe o número do PIS: ", null));
        funcionario.setCriadoEm(new Date());
        funcionario.setCriadoPor(null);
        funcionario.setAlteradoEm(new Date());
        funcionario.setAlteradoPor(null);
        funcionarioController.inserir(funcionario);
        exibeDialogo("Cliente inserido com sucesso!");
        imprimeCliente(funcionarioController.recuperarPorCpf(funcionario.getCpf()));
        
            
        } catch (Exception e) {
            // TODO: handle exception
        }
     
    }
    




}