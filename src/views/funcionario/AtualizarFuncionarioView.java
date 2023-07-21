package views.funcionario;

import controllers.interfaces.IFuncionarioController;
import models.Funcionario;
import utils.DateUtils;
import utils.enums.Cargo;
import utils.enums.Disponibilidade;
import utils.enums.Escolaridade;
import utils.enums.EstadoCivil;

import java.util.Date;

import static views.View.exibeDialogo;
import static views.View.solicitaEntradaDeDado;
import static views.funcionario.SubmenuFuncionarioView.imprimeFuncionario;;

public class AtualizarFuncionarioView {
    static void atualizar(IFuncionarioController funcionarioController) {

        // TODO ver se existe alguma maneira mais simples de mostrar submenus

        try {
            String cpf = solicitaEntradaDeDado("Informe o CPF do Funcionario que deseja alterar:");
            Funcionario funcionario = funcionarioController.buscaPorCpf(cpf);

            if (funcionario != null) {
                funcionario.setNome(solicitaEntradaDeDado("Nome:", funcionario.getNome()));
                funcionario.setTelefone(solicitaEntradaDeDado("Telefone:", funcionario.getTelefone()));
                funcionario.setEndereco(solicitaEntradaDeDado("Endereço: ", funcionario.getEndereco()));
                funcionario.setCpf(solicitaEntradaDeDado("CPF:", funcionario.getCpf()));
                funcionario.setPis(solicitaEntradaDeDado("PIS", funcionario.getPis()));
                funcionario.setSenha(solicitaEntradaDeDado("Senha",funcionario.getSenha()));
              
                //função para datas de nascimento
                funcionario.setNascimento(
                        DateUtils.stringToDate(solicitaEntradaDeDado("Data de nascimento: \nFormato: dd/mm/yyyy",
                                DateUtils.dateToString(funcionario.getNascimento()))));

                //função booleana para ativo 
                boolean ativo = solicitaEntradaDeDado("Ativo?\n 0 - Não \n 1 - Sim", funcionario.getAtivo() ? "1" : "0")
                        .equals("1") ? true : false;
                funcionario.setAtivo(ativo);

                // Criando String para cargos
                String stringCargos = 
                "Selecione o cargo:\n1 - Auxiliar de Cozinha \n2 - Balconista \n3 - Bartender \n4 - Cheff \n5 - Garçon \n6 - Gerente \n7 - Recepcionista";
                String stringAtualizarCargo = solicitaEntradaDeDado(stringCargos,
                        funcionario.getCargo().ordinal() + "");
                funcionario.setCargo(Cargo.values()[Integer.parseInt(stringAtualizarCargo) + 1]);

                //Criando String para Escolaridade
                String stringEscolaridade = 
                "Selecione a escolaridade: \n1 Ensino fundamental \n2 Ensino médio \n3 Ensino superior";
                String stringAtualizarEscolaridade = solicitaEntradaDeDado(stringEscolaridade,
                        funcionario.getEscolaridade().ordinal() + "");
                funcionario.setEscolaridade(Escolaridade.values()[Integer.parseInt(stringAtualizarEscolaridade) + 1]);

                //Criando String para Disponibilidade 
                String stringDisponibilidade = 
                "Selecione a disponibilidade do funcionario:  \n1 Ocupado \n2 Diponível";
                String stringAtualizarDisponibilidade = solicitaEntradaDeDado(stringDisponibilidade,
                        funcionario.getEscolaridade().ordinal() + "");
                funcionario.setDisponibilidade(Disponibilidade.values()[Integer.parseInt(stringAtualizarDisponibilidade) + 1]);

                //Criando String para Estado Civil
                String stringEstadoCivil = 
                "Selecione o estado civil:  \n1 Solteiro \n2 Casado \n3 Separado \n4 Divorciado \n5 Viuvo";
                String stringAtualizarEsatdoCivil = solicitaEntradaDeDado(stringEstadoCivil,
                        funcionario.getEstadoCivil().ordinal() + "");
                funcionario.setEstadoCivil(EstadoCivil.values()[Integer.parseInt(stringAtualizarEsatdoCivil) + 1]);

                funcionario.setAlteradoEm(new Date());
                funcionario.setAlteradoPor(null);
                funcionarioController.atualizar(funcionario);
                exibeDialogo("Funcionario atualizado com sucesso!");
                imprimeFuncionario(funcionarioController.buscaPorCpf(funcionario.getCpf()));
            } else {
                exibeDialogo("Funcionario não encontrado!");
            }
        } catch (Exception e) {
            exibeDialogo("Dado informado inválido!\nCadastro não finalizado...");
            e.printStackTrace();
        }
    }
}
