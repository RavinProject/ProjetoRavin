package org.ravin.utils.interfaces;

import java.util.List;

public interface IGeradorId<T> {
    List<T> pegarLista();
    int getId(T t);

    default int geraProximoId() {
        int maiorId = 0;
        for (T t : pegarLista()) {
            if (getId(t) > maiorId) {
                maiorId = getId(t);
            }
        }
        return maiorId + 1;
    }
}