package views.funcionario;

import java.util.Date;
import java.util.InputMismatchException;

import controllers.FuncionarioController;
import utils.enums.Cargo;
import utils.enums.Disponibilidade;
import utils.enums.Escolaridade;
import utils.enums.EstadoCivil;
import models.Funcionario;
import utils.DateUtils;
import views.View;

public class SubmenuFuncionario extends View {

    // TODO Desacoplar funções em outras classes

    public static void menu() {
        boolean exec = true;
        while (exec) {
            String opcao = solicitaEntradaDeDado(menuInicial());
            switch (opcao) {
                case "1" -> cadastrar();
                case "2" -> atualizar();
                case "3" -> listarFuncionarios();
                case "4" -> pesquisarFuncionarioPorCpf();
                case "5" -> excluirFuncionario();
                case "x" -> exec = false;
                default -> exibeDialogo("Opção inválida! Voltando...");
            }
        }
    }

    private static String menuInicial(){
        StringBuilder builder = new StringBuilder();
        builder.append("""
                ==================== RAVIN ====================
                FUNCIONÁRIO:
                1 - Cadastrar Funcionário
                2 - Alterar Funcionário
                3 - Listar Funcionários
                4 - Visualizar Funcionário
                5 - Excluir Funcionário
                x - voltar
                """);
        return builder.toString();
    }

    private static void cadastrar() {
        FuncionarioController funcionarioControler = new FuncionarioController();
        Funcionario funcionario = new Funcionario();
        try {
            funcionario.setNome(solicitaEntradaDeDado("Informe o nome do funcionário:"));
            funcionario.setTelefone(solicitaEntradaDeDado("Informe o telefone:"));
            funcionario.setEndereco(solicitaEntradaDeDado("Endereço: "));
            funcionario.setCpf(solicitaEntradaDeDado("Informe o CPF:"));
            funcionario.setNascimento(DateUtils.stringToDate(solicitaEntradaDeDado("Data de nascimento: \nFormato: dd/mm/yyyy")));
            funcionario.setObservacao(solicitaEntradaDeDado("Informe uma observação ou tecle enter para continuar:"));
            funcionario.setRg(solicitaEntradaDeDado("Informe o RG:"));
            String estadoCivil = "Informe uma opção para o estado civil:\n1 - Solteiro\n2 - Casado\n3 - Separado\n4 - Divorciado\n5 - Viúvo";
            funcionario.setEstadoCivil(EstadoCivil.values()[Integer.parseInt(solicitaEntradaDeDado(estadoCivil)) - 1]);
            String escolaridade = "Informe uma opção para a escolaridade:\n1 - Fundamental\n2 - Médio\n3 - Superior";
            funcionario.setEscolaridade(Escolaridade.values()[Integer.parseInt(solicitaEntradaDeDado(escolaridade)) - 1]);
            funcionario.setPis(solicitaEntradaDeDado("Informe o número do PIS:"));
            funcionario.setSenha(solicitaEntradaDeDado("Informe uma senha para acesso ao sistema:"));
            funcionario.setDataAdmissao(DateUtils.stringToDate(solicitaEntradaDeDado("Informe a data de admissão no formato dd/mm/yyyy:")));
            String stringCargos = "Selecione o cargo:";
            stringCargos += "\n1 - Auxiliar de Cozinha";
            stringCargos += "\n2 - Balconista";
            stringCargos += "\n3 - Bartender";
            stringCargos += "\n4 - Cheff";
            stringCargos += "\n5 - Garçon";
            stringCargos += "\n6 - Gerente";
            stringCargos += "\n7 - Recepcionista";
            funcionario.setCargo(Cargo.values()[Integer.parseInt(solicitaEntradaDeDado(stringCargos)) - 1]);
            funcionario.setAtivo(true);
            funcionario.setDisponibilidade(Disponibilidade.DISPONIVEL);
            funcionario.setCriadoEm(new Date());
            funcionario.setCriadoPor(null);
            funcionario.setAlteradoEm(new Date());
            funcionario.setAlteradoPor(null);
            funcionarioControler.inserir(funcionario);
            exibeDialogo("Funcionário inserido com sucesso!");
            imprimeFuncionario(funcionarioControler.buscaPorCpf(funcionario.getCpf()));
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            exibeDialogo("Um erro ocorreu!\nCadastro não finalizado...");
            e.printStackTrace();
        }
    }

    private static void atualizar() {
        FuncionarioController funcionarioControler = new FuncionarioController();
        
        try {
            String cpf = solicitaEntradaDeDado("Informe o CPF do funcionário que deseja alterar:");
            Funcionario funcionario = funcionarioControler.buscaPorCpf(cpf);
            
            funcionario.setNome(solicitaEntradaDeDado("Informe o nome do funcionário:", funcionario.getNome()));
            funcionario.setTelefone(solicitaEntradaDeDado("Informe o telefone:", funcionario.getTelefone()));
            funcionario.setEndereco(solicitaEntradaDeDado("Endereço: ", funcionario.getEndereco()));
            funcionario.setCpf(solicitaEntradaDeDado("Informe o CPF:", funcionario.getCpf()));
            funcionario.setNascimento(DateUtils.stringToDate(solicitaEntradaDeDado("Data de nascimento: \nFormato: dd/mm/yyyy", DateUtils.dateToString(funcionario.getNascimento()))));
            funcionario.setObservacao(solicitaEntradaDeDado("Informe uma observação ou tecle enter para continuar:", funcionario.getObservacao()));
            funcionario.setRg(solicitaEntradaDeDado("Informe o RG:", funcionario.getRg()));
            String estadoCivil = "Informe uma opção para o estado civil:\n1 - Solteiro\n2 - Casado\n3 - Separado\n4 - Divorciado\n5 - Viúvo";
            funcionario.setEstadoCivil(EstadoCivil.values()[Integer.parseInt(solicitaEntradaDeDado(estadoCivil, funcionario.getEstadoCivil().ordinal() + "")) + 1]);
            String escolaridade = "Informe uma opção para a escolaridade:\n1 - Fundamental\n2 - Médio\n3 - Superior";
            funcionario.setEscolaridade(Escolaridade.values()[Integer.parseInt(solicitaEntradaDeDado(escolaridade, funcionario.getEscolaridade().ordinal() + "")) + 1]);
            funcionario.setPis(solicitaEntradaDeDado("Informe o número do PIS:", funcionario.getPis()));
            funcionario.setSenha(solicitaEntradaDeDado("Informe uma senha para acesso ao sistema:", funcionario.getSenha()));
            funcionario.setDataAdmissao(DateUtils.stringToDate(solicitaEntradaDeDado("Informe a data de admissão no formato dd/mm/yyyy:", DateUtils.dateToString(funcionario.getDataAdmissao()))));
            String stringCargos = "Selecione o cargo:";
            stringCargos += "\n1 - Auxiliar de Cozinha";
            stringCargos += "\n2 - Balconista";
            stringCargos += "\n3 - Bartender";
            stringCargos += "\n4 - Cheff";
            stringCargos += "\n5 - Garçon";
            stringCargos += "\n6 - Gerente";
            stringCargos += "\n7 - Recepcionista";
            funcionario.setCargo(Cargo.values()[Integer.parseInt(solicitaEntradaDeDado(stringCargos, funcionario.getCargo().ordinal() + "")) + 1]);
            funcionario.setAtivo(true);
            funcionario.setDisponibilidade(Disponibilidade.values()[Integer.parseInt(solicitaEntradaDeDado("Disponibilidade:\n1 - Ocupado\n2 - Disponível", funcionario.getDisponibilidade().ordinal() + "")) + 1]);
            funcionario.setAlteradoEm(new Date());
            funcionario.setAlteradoPor(null);
            funcionarioControler.atualizar(funcionario);
            exibeDialogo("Funcionário atualizado com sucesso!");
            imprimeFuncionario(funcionarioControler.buscaPorCpf(funcionario.getCpf()));
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            exibeDialogo("Um erro ocorreu!\nCadastro não finalizado...");
            e.printStackTrace();
        }
    }

    private static void pesquisarFuncionarioPorCpf() {
        FuncionarioController funcionarioController = new FuncionarioController();

        String cpf = solicitaEntradaDeDado("Informe o CPF do cliente que deseja alterar:");
        Funcionario funcionario = funcionarioController.buscaPorCpf(cpf);
        
        if (funcionario != null) {
            imprimeFuncionario(funcionario);
        } else {
            exibeDialogo("Funcionário não encontrado com o cpf informado!");
        }
    }


    private static void imprimeFuncionario(Funcionario funcionario) {
        String funcionarioDados = "ID: " + funcionario.getId() +
                        "\nNome: " + funcionario.getNome() +
                        "\nTelefone: " + funcionario.getTelefone() +
                        "\nEndereço: " + funcionario.getEndereco() +
                        "\nCPF: " + funcionario.getCpf() +
                        "\nNascimento: " + DateUtils.dateToString(funcionario.getNascimento()) +
                        "\nObservação: " + funcionario.getObservacao() +
                        "\nAtivo: " + (funcionario.getAtivo() ? "Sim" : "Não") +
                        "\nRG: " + funcionario.getRg() +
                        "\nEstado Civil: " + funcionario.getEstadoCivilString() +
                        "\nEscolaridade: " + funcionario.getEscolaridadeString() +
                        "\nCargo: " + funcionario.getCargoString() +
                        "\nPIS: " + funcionario.getPis() +
                        "\nSenha: " + funcionario.getSenha() +
                        "\nData Admissão: " + DateUtils.dateToString(funcionario.getDataAdmissao()) +
                        "\nData Demissão: " + DateUtils.dateToString(funcionario.getDataDemissao()) +
                        "\nDisponibilidade: " + funcionario.getDisponibilidadeString();
        exibeDialogo(funcionarioDados);
    }

    private static void listarFuncionarios() {
        FuncionarioController funcionarioController = new FuncionarioController();
        StringBuilder texto = new StringBuilder();

        for (Funcionario funcionario : funcionarioController.pegarLista()) {
            texto.append("ID: ")
                    .append(funcionario.getId())
                    .append(" CPF: ")
                    .append(funcionario.getCpf())
                    .append(funcionario.getAtivo() ? " " : " (INATIVO) ")
                    .append(funcionario.getNome())
                    .append(" (")
                    .append(funcionario.getCargoString().toUpperCase())
                    .append(")\n");
        }
        exibeDialogo(texto.toString());
    }

    private static void excluirFuncionario() {
        FuncionarioController clienteControler = new FuncionarioController();
        try {
            String cpf = solicitaEntradaDeDado("Informe o CPF do funcionário que deseja alterar:");
            Funcionario funcionario = clienteControler.buscaPorCpf(cpf);
           
            if (funcionario != null) {
                String funcionarioDados = "O seguinte funcionário será excluído:" +
                        "\n\nID: " + funcionario.getId() +
                        "\nNome: " + funcionario.getNome() +
                        "\nTelefone: " + funcionario.getTelefone() +
                        "\nEndereço: " + funcionario.getEndereco() +
                        "\nCPF: " + funcionario.getCpf() +
                        "\n\nClique em OK para confirmar ou Cancele.";
                if(confirmaAcao(funcionarioDados) == JOptionPane.YES_OPTION){
                    boolean excluido = clienteControler.remover(funcionario);
                    exibeDialogo(excluido ? "O funcionário foi removido!" : "Não foi possível excluir o funcionário da lista");
                }else{
                    exibeDialogo("Nada foi alterado!");
                }
            } else {
                exibeDialogo("Funcionário não encontrado com o cpf informado!");
            }
        } catch (Exception e) {
            exibeDialogo("Dado informado inválido!\nCadastro não finalizado...");
            e.printStackTrace();
        }
    }
}
