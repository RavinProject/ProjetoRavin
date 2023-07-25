package org.ravin.views.funcionario;

import java.util.Date;
import java.util.InputMismatchException;

import org.ravin.controllers.interfaces.IFuncionarioController;
import org.ravin.models.Funcionario;
import org.ravin.utils.DateUtils;
import org.ravin.utils.enums.Escolaridade;
import org.ravin.utils.enums.Cargo;
import org.ravin.utils.enums.Disponibilidade;
import org.ravin.utils.enums.EstadoCivil;

import static org.ravin.views.View.*;
import static org.ravin.views.funcionario.SubmenuFuncionario.imprimeFuncionario;;

public class CadastrarFuncionarioView {

    static void cadastrarFuncionario(IFuncionarioController funcionarioController) {
        try {
            Funcionario funcionario = new Funcionario();
            funcionario.setSenha(solicitaEntradaDeDadoValida("(obrigatório) Cadastre sua senha: "));
            funcionario.setNome(solicitaEntradaDeDado("Informe o nome do Funcionario "));
            funcionario.setPis(solicitaEntradaDeDado("Informe o número do PIS: "));
            funcionario.setCpf(solicitaEntradaDeDado("Informe o CPF: "));
            funcionario.setCargo(solicitaEnum("Selecione o Cargo", Cargo.values()));
            funcionario.setEscolaridade(solicitaEnum("Selecione a escolaridade", Escolaridade.values()));
            funcionario.setEstadoCivil(solicitaEnum("Selecione o estado civil", EstadoCivil.values()));
            funcionario.setDisponibilidade(solicitaEnum("Selecione a disponibilidade do funcionario", Disponibilidade.values()));
            funcionario.setTelefone(solicitaEntradaDeDado("Informe o telefone: "));
            funcionario.setEndereco(solicitaEntradaDeDado("Endereço: "));
            funcionario.setNascimento(DateUtils.stringToDate(solicitaEntradaDeDado("Data de nascimento: \nFormato: dd/mm/yyyy")));
            funcionario.setDataAdmissao(DateUtils.stringToDate(solicitaEntradaDeDado("Data de admissão: \nFormato: dd/mm/yyyy")));
            funcionario.setStatusAtivo(true);
            funcionario.setCriadoEm(new Date());
            funcionario.setCriadoPor(null);
            funcionario.setAlteradoEm(new Date());
            funcionario.setAlteradoPor(null);
            funcionarioController.inserir(funcionario);
            exibeDialogo("Funcionario cadastrado com sucesso!");
            imprimeFuncionario(funcionarioController.buscaPorCpf(funcionario.getCpf()));
        } catch (InputMismatchException e) {
            exibeDialogo("Por favor, insira os dados corretamente!\nCadastro não finalizado...");
            e.printStackTrace();
        } catch (Exception e) {
            exibeDialogo("Um erro ocorreu!\nCadastro não finalizado...");
            e.printStackTrace();
        }
    }

    static <E extends Enum<E>> E solicitaEnum(String mensagem, E[] values) {
        StringBuilder sb = new StringBuilder(mensagem);
        for (int i = 0; i < values.length; i++) {
            sb.append("\n").append(i + 1).append(" ").append(values[i].name());
        }
        return values[Integer.parseInt(solicitaEntradaDeDadoValida(sb.toString())) - 1];
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
}
