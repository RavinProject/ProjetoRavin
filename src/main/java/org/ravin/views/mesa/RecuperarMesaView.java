package org.ravin.views.mesa;

import org.ravin.controllers.interfaces.IMesaController;
import org.ravin.models.Mesa;
import org.ravin.utils.exceptions.EntidadeNaoEncontradaException;

import static org.ravin.views.View.exibeDialogo;
import static org.ravin.views.View.solicitaEntradaDeDado;
import static org.ravin.views.mesa.SubmenuMesa.imprimeMesa;

public class RecuperarMesaView {
    static void recuperarMesaPorCodigo(IMesaController mesaController) {

        String codigo = String.valueOf(solicitaEntradaDeDado("Informe o código da mesa que deseja visualizar:"));
        try{
            Mesa mesa = mesaController.recuperarPorCodigo(codigo);
            imprimeMesa(mesa);
        }catch(EntidadeNaoEncontradaException e){
            exibeDialogo(e.getMessage());
        }
    }

    static void listarMesas(IMesaController mesaController) {
        StringBuilder texto = new StringBuilder();
        for (Mesa mesa : mesaController.recuperarTodos()) {
            texto.append("ID da Mesa: ")
                    .append(mesa.getId())
                    .append(", Código da Mesa: ")
                    .append(mesa.getCodigo())
                    .append(", Funcionário Responsável: ")
                    .append(mesa.getFuncionario().getNome())
                    .append(", Status da Mesa: ")
                    .append(mesa.getStatusMesa())
                    .append("\n\n");
        }
        exibeDialogo(texto.toString());
    }

}
