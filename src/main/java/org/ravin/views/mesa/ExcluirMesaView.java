package org.ravin.views.mesa;

import org.ravin.controllers.interfaces.IMesaController;
import org.ravin.models.Mesa;

import javax.swing.*;

import static org.ravin.views.View.*;

public class ExcluirMesaView {
    static void excluirMesa(IMesaController mesaController) {
        try {
            String codigo = solicitaEntradaDeDado("Informe o Código da Mesa que deseja excluir:");
            if (codigo == null) return;
            Mesa mesa = mesaController.recuperarPorCodigo(codigo);

            if (mesa != null) {
                String mesaDados = "A seguinte mesa será excluída:" +
                        "\n\nID: " + mesa.getId() +
                        "\nCódigo: " + mesa.getCodigo() +
                        "\nNúmero: " + mesa.getNumero() +
                        "\nQuantidade Máxima: " + mesa.getQuantidadeMaxima() +
                        "\n\nClique em OK para confirmar ou Cancele.";
                if(confirmaAcao(mesaDados) == JOptionPane.YES_OPTION){
                    boolean excluido = mesaController.remover(mesa);
                    exibeDialogo(excluido ? "A mesa foi removida!" : "Não foi possível excluir a mesa da lista");
                } else {
                    exibeDialogo("Nada foi alterado!");
                }
            } else {
                exibeDialogo("Mesa não encontrada com o código informado!");
            }
        } catch (Exception e) {
            exibeDialogo("Dado informado inválido!\nExclusão não finalizada...");
            e.printStackTrace();
        }
    }
}