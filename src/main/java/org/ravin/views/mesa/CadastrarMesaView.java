package org.ravin.views.mesa;

import org.ravin.controllers.interfaces.IMesaController;
import org.ravin.models.Mesa;
import org.ravin.utils.enums.StatusMesa;

import java.util.Date;
import java.util.InputMismatchException;

import static org.ravin.views.View.exibeDialogo;
import static org.ravin.views.View.solicitaEntradaDeDado;
import static org.ravin.views.mesa.SubmenuMesa.imprimeMesa;

public class CadastrarMesaView {

    static void cadastrarMesa(IMesaController mesaController) {
        try {
            String codigo = solicitaEntradaDeDadoValida("Informe o código da Mesa: ");
            int numero = Integer.parseInt(solicitaEntradaDeDadoValida("Informe o número da Mesa: "));
            int quantidadeMaxima = Integer.parseInt(solicitaEntradaDeDadoValida("Informe a quantidade máxima de lugares da Mesa: "));
            Date agora = new Date();

            Mesa mesa = new Mesa(codigo, numero, quantidadeMaxima);
            mesa.setCriadoEm(agora);
            mesa.setCriadoPor("Sistema");  // Aqui poderia ser o usuário logado
            mesa.setStatusMesa(StatusMesa.LIVRE);

            mesaController.inserir(mesa);
            exibeDialogo("Mesa cadastrada com sucesso!");
            imprimeMesa(mesa);
        } catch (InputMismatchException e) {
            exibeDialogo("Por favor, insira os dados corretamente!\nCadastro não finalizado...");
            e.printStackTrace();
        } catch (Exception e) {
            exibeDialogo("Um erro ocorreu!\nCadastro não finalizado...");
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
}
