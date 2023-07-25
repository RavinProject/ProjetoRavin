package org.ravin.views.funcionario;

import org.ravin.controllers.interfaces.IFuncionarioController;
import org.ravin.models.Funcionario;
import org.ravin.utils.DateUtils;
import org.ravin.utils.enums.Cargo;
import org.ravin.utils.enums.Disponibilidade;
import org.ravin.utils.enums.Escolaridade;
import org.ravin.utils.enums.EstadoCivil;

import java.util.Date;
import java.util.InputMismatchException;

import static org.ravin.views.View.exibeDialogo;
import static org.ravin.views.View.solicitaEntradaDeDado;
import static org.ravin.views.funcionario.SubmenuFuncionario.imprimeFuncionario;

public class CadastrarFuncionarioView {

    static void cadastrarFuncionario(IFuncionarioController funcionarioController) {
        try {
            String senha = solicitaEntradaDeDadoValida("(obrigatório) Cadastre sua senha: ");
            String nome = solicitaEntradaDeDado("Informe o nome do Funcionario ");
            String pis = solicitaEntradaDeDado("Informe o número do PIS: ");
            String cpf = solicitaEntradaDeDado("Informe o CPF: ");
            Cargo cargo = solicitaEnum("Selecione o Cargo", Cargo.values());
            Escolaridade escolaridade = solicitaEnum("Selecione a escolaridade", Escolaridade.values());
            EstadoCivil estadoCivil = solicitaEnum("Selecione o estado civil", EstadoCivil.values());
            Disponibilidade disponibilidade = solicitaEnum("Selecione a disponibilidade do funcionario", Disponibilidade.values());
            String telefone = solicitaEntradaDeDado("Informe o telefone: ");
            String endereco = solicitaEntradaDeDado("Endereço: ");
            Date nascimento = DateUtils.stringToDate(solicitaEntradaDeDado("Data de nascimento: \nFormato: dd/mm/yyyy"));
            Date dataAdmissao = DateUtils.stringToDate(solicitaEntradaDeDado("Data de admissão: \nFormato: dd/mm/yyyy"));
            Date agora = new Date();

            Funcionario funcionario = new Funcionario(nome, telefone, endereco, cpf, nascimento, "", true, agora, agora, estadoCivil, escolaridade, cargo, pis, senha, dataAdmissao, null, disponibilidade);

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
