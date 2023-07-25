package org.ravin.views.funcionario;

import org.ravin.controllers.interfaces.IFuncionarioController;
import org.ravin.models.Funcionario;
import org.ravin.utils.DateUtils;
import org.ravin.utils.enums.Cargo;
import org.ravin.utils.enums.Disponibilidade;
import org.ravin.utils.enums.Escolaridade;
import org.ravin.utils.enums.EstadoCivil;

import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.ravin.views.View.exibeDialogo;
import static org.ravin.views.View.solicitaEntradaDeDado;
import static org.ravin.views.funcionario.SubmenuFuncionario.imprimeFuncionario;

public class AtualizarFuncionarioView {
    static void atualizar(IFuncionarioController funcionarioController) {
        try {
            String cpf = solicitaEntradaDeDadoValida("Informe o CPF do Funcionario que deseja alterar:");
            if (cpf == null) return;
            Funcionario funcionario = funcionarioController.buscaPorCpf(cpf);

            if (funcionario != null) {
                funcionario.setNome(solicitaEntradaDeDado("Nome:", funcionario.getNome()));
                funcionario.setTelefone(solicitaEntradaDeDado("Telefone:", funcionario.getTelefone()));
                funcionario.setEndereco(solicitaEntradaDeDado("Endereço: ", funcionario.getEndereco()));
                funcionario.setCpf(solicitaEntradaDeDado("CPF:", funcionario.getCpf()));
                funcionario.setPis(solicitaEntradaDeDado("PIS", funcionario.getPis()));
                funcionario.setSenha(solicitaEntradaDeDado("Senha",funcionario.getSenha()));
                funcionario.setNascimento(solicitaData("Data de nascimento: ", funcionario.getNascimento()));
                funcionario.setStatusAtivo(solicitaBoolean("Ativo?\n 0 - Não \n 1 - Sim", funcionario.getAtivo()));
                funcionario.setCargo(solicitaEnum("Selecione o cargo:", Cargo.values(), funcionario.getCargo()));
                funcionario.setEscolaridade(solicitaEnum("Selecione a escolaridade:", Escolaridade.values(), funcionario.getEscolaridade()));
                funcionario.setDisponibilidade(solicitaEnum("Selecione a disponibilidade do funcionario:", Disponibilidade.values(), funcionario.getDisponibilidade()));
                funcionario.setEstadoCivil(solicitaEnum("Selecione o estado civil:", EstadoCivil.values(), funcionario.getEstadoCivil()));
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

    static String solicitaEntradaDeDadoValida(String mensagem) {
        String entrada;
        do {
            entrada = solicitaEntradaDeDado(mensagem);
            if (entrada == null || entrada.trim().isEmpty()) {
                exibeDialogo("Entrada inválida. Por favor, tente novamente.");
            }
        } while (entrada == null || entrada.trim().isEmpty());
        return entrada;
    }

    static Date solicitaData(String mensagem, Date dataAtual) {
        String entrada = solicitaEntradaDeDado(mensagem, DateUtils.dateToString(dataAtual));
        return DateUtils.stringToDate(entrada);
    }

    static boolean solicitaBoolean(String mensagem, boolean valorAtual) {
        String entrada = solicitaEntradaDeDado(mensagem, valorAtual ? "1" : "0");
        return entrada.equals("1");
    }

    static <E extends Enum<E>> E solicitaEnum(String mensagem, E[] values, E valorAtual) {
        String stringOpcoes = IntStream.range(0, values.length)
                .mapToObj(i -> (i + 1) + " - " + values[i].name())
                .collect(Collectors.joining("\n"));
        String entrada = solicitaEntradaDeDado(mensagem + "\n" + stringOpcoes, String.valueOf(valorAtual.ordinal() + 1));
        return values[Integer.parseInt(entrada) - 1];
    }
}