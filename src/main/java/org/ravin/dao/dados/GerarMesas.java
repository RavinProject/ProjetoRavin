package org.ravin.dao.dados;

import org.ravin.models.Funcionario;
import org.ravin.models.Mesa;
import org.ravin.utils.enums.StatusMesa;

import java.util.ArrayList;
import java.util.List;

public class GerarMesas {

    private static final String MESA_NOME = "MESA";
    private static final String MESA_CODIGO = "MESA";

    public static List<Mesa> montaLista(List<Funcionario> funcionariosList) {
        List<Mesa> mesas = new ArrayList<>();
        int[] quantidadesMaximas = {1, 2, 4, 5, 6, 8};
        StatusMesa[] statuses = StatusMesa.values();

        for (int i = 0; i < quantidadesMaximas.length; i++) {
            Mesa mesa = new Mesa(MESA_CODIGO + (i+1), i+1, quantidadesMaximas[i]);
            mesa.setId(i+1);
            mesa.setFuncionario(funcionariosList.get(i));
            mesa.setStatusMesa(statuses[i % statuses.length]);
            mesas.add(mesa);
        }

        return mesas;
    }
}
