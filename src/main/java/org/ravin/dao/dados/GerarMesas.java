package org.ravin.dao.dados;

import org.ravin.models.Comanda;
import org.ravin.models.Funcionario;
import org.ravin.models.Mesa;
import org.ravin.utils.enums.StatusMesa;

import java.util.ArrayList;
import java.util.List;

public class GerarMesas {

    private static final String MESA_NOME = "MESA";
    private static final String MESA_CODIGO = "MESA";

    public static List<Mesa> montaLista(List<Funcionario> funcionariosList, List<Comanda> comandasList) {
        List<Mesa> mesas = new ArrayList<>();
        int[] quantidadesMaximas = {2, 4, 6, 8};

        for (int i = 0; i < quantidadesMaximas.length; i++) {
            Mesa mesa = new Mesa(MESA_NOME + (i+1), MESA_CODIGO + (i+1), i+1, quantidadesMaximas[i]);

            // Definir o primeiro funcionário como responsável pela mesa
            mesa.setFuncionario(funcionariosList.get(0));

            if (i != 0) {
                // Cria uma lista de comandas com clientes até o máximo de assentos da mesa
                List<Comanda> comandasMesa = new ArrayList<>();
                for (int j = 0; j < quantidadesMaximas[i] && j < comandasList.size(); j++) {
                    comandasMesa.add(comandasList.get(j));
                }

                mesa.setComandas(comandasMesa);
                mesa.setStatusMesa(StatusMesa.OCUPADA);
            } else {
                // A primeira mesa não tem comandas
                mesa.setStatusMesa(StatusMesa.LIVRE);
            }

            mesas.add(mesa);
        }

        return mesas;
    }
}

