package org.ravin.views.mesa;

import org.ravin.controllers.interfaces.IMesaController;
import org.ravin.models.Mesa;
import org.ravin.utils.enums.StatusMesa;
import org.ravin.utils.exceptions.EntidadeNaoEncontradaException;

import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.ravin.views.View.exibeDialogo;
import static org.ravin.views.View.solicitaEntradaDeDado;
import static org.ravin.views.mesa.SubmenuMesa.imprimeMesa;

public class AlterarMesaView {
    static void atualizarMesa(IMesaController mesaController) {
        try {
            String codigo = solicitaEntradaDeDadoValida();
            Mesa mesa = mesaController.recuperarPorCodigo(codigo);
            mesa.setCodigo(solicitaEntradaDeDado("Código:", mesa.getCodigo()));
            mesa.setNumero(Integer.parseInt(solicitaEntradaDeDado("Número:", String.valueOf(mesa.getNumero()))));
            mesa.setQuantidadeMaxima(Integer.parseInt(solicitaEntradaDeDado("Quantidade Máxima:", String.valueOf(mesa.getQuantidadeMaxima()))));
            mesa.setStatusMesa(solicitaEnum(StatusMesa.values(), mesa.getStatusMesa()));
            mesa.setAlteradoEm(new Date());
            mesa.setAlteradoPor(null); // Talvez adicionar o usuário logado mais para frente
            mesaController.atualizar(mesa);
            exibeDialogo("Mesa atualizada com sucesso!");
            imprimeMesa(mesaController.recuperarPorCodigo(mesa.getCodigo()));

        } catch (EntidadeNaoEncontradaException e) {
            exibeDialogo(e.getMessage());
        } catch (Exception e) {
            exibeDialogo("Dado informado inválido!\nAtualização não finalizada...");
            e.printStackTrace();
        }
    }

    static String solicitaEntradaDeDadoValida() {
        String entrada;
        do {
            entrada = solicitaEntradaDeDado("Informe o Código da Mesa que deseja alterar:");
            if (entrada == null || entrada.trim().isEmpty()) {
                exibeDialogo("Entrada inválida. Por favor, tente novamente.");
            }
        } while (entrada == null || entrada.trim().isEmpty());
        return entrada;
    }

    static <E extends Enum<E>> E solicitaEnum(E[] values, E valorAtual) {
        String stringOpcoes = IntStream.range(0, values.length)
                .mapToObj(i -> (i + 1) + " - " + values[i].name())
                .collect(Collectors.joining("\n"));
        String entrada = solicitaEntradaDeDado("Selecione o status da mesa:" + "\n" + stringOpcoes,
                String.valueOf(valorAtual.ordinal() + 1));
        return values[Integer.parseInt(entrada) - 1];
    }
}
