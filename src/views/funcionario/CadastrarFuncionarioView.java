package views.funcionario;

import java.util.Date;
import java.util.InputMismatchException;

import controllers.interfaces.IFuncionarioController;
import models.Funcionario;
import utils.DateUtils;
import utils.enums.Escolaridade;
import utils.enums.Cargo;
import utils.enums.Disponibilidade;
import utils.enums.EstadoCivil;

import static views.View.*;
import static views.funcionario.SubmenuFuncionarioView.imprimeFuncionario;;



public class CadastrarFuncionarioView{

    static void cadastrarFuncionario(IFuncionarioController funcionarioController) {
        Funcionario funcionario = new Funcionario();
        try {   
        funcionario.setSenha(solicitaEntradaDeDado("(obrigatório) Cadastre sua senha: "));
        funcionario.setNome(solicitaEntradaDeDado("Informe o nome do Funcionario "));
        funcionario.setPis(solicitaEntradaDeDado("Informe o número do PIS: "));
        funcionario.setCpf(solicitaEntradaDeDado("Informe o CPF: "));  
        
        //Criando String para cargos 
        String StringTipoCargos = 
        "Selecione o Cargo: \n1 Auxiliar de cozinha \n2 Balconista \n3 Bartender \n4 Cheff \n5 Garçom \n6 Gerente \n7 Recepcionista";
        funcionario.setCargo(Cargo.values()[Integer.parseInt(solicitaEntradaDeDado(StringTipoCargos)) - 1]);
        
        //Criando String para nivel de escolaridade
        String StringTipoEscolaridade =
        "Selecione a escolaridade: \n1 Ensino fundamental \n2 Ensino médio \n3 Ensino superior";
        funcionario.setEscolaridade(Escolaridade.values()[Integer.parseInt(solicitaEntradaDeDado(StringTipoEscolaridade)) - 1]);
        
        //Criando String para estado civil
        String stringTipoEstadoCivil = "Selecione o estado civil:  \n1 Solteiro \n2 Casado \n3 Separado \n4 Divorciado \n5 Viuvo";        
        funcionario.setEstadoCivil(EstadoCivil.values()[Integer.parseInt(solicitaEntradaDeDado(stringTipoEstadoCivil)) - 1]);
       
        //Criando String para disponibilidade
        String stringTipoDisponibilidade = "Selecione a disponibilidade do funcionario:  \n1 Ocupado \n2 Diponível";
        funcionario.setDisponibilidade(Disponibilidade.values()[Integer.parseInt(solicitaEntradaDeDado(stringTipoDisponibilidade)) - 1]);

        funcionario.setTelefone(solicitaEntradaDeDado("Informe o telefone: "));
        funcionario.setEndereco(solicitaEntradaDeDado("Endereço: "));
        funcionario.setNascimento(DateUtils.stringToDate(solicitaEntradaDeDado("Data de nascimento: \nFormato: dd/mm/yyyy")));
        funcionario.setDataAdmissao(DateUtils.stringToDate(solicitaEntradaDeDado("Data de admissão: \nFormato: dd/mm/yyyy")));
        funcionario.setDataDemissao(DateUtils.stringToDate(solicitaEntradaDeDado("Data de demissão:  \nFormato: dd/mm/yyyy")));
        funcionario.setCriadoEm(new Date());
        funcionario.setCriadoPor(null);
        funcionario.setAlteradoEm(new Date());
        funcionario.setAlteradoPor(null);
        funcionarioController.inserir(funcionario);
        exibeDialogo("Funcionario cadastrado com sucesso!");
        imprimeFuncionario(funcionarioController.buscaPorCpf(funcionario.getCpf()));
        }  catch(InputMismatchException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            exibeDialogo("Um erro ocorreu!\nCadastro não finalizado...");
            e.printStackTrace();
        }
    }
}
