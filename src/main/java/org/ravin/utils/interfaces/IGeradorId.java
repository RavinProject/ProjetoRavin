package org.ravin.utils.interfaces;

import java.util.List;

public interface IGeradorId<T> {
    int getId(T t);

    default int geraProximoId(List<T> lista) {
        int maiorId = 0;
        for (T t : lista) {
            if (getId(t) > maiorId) {
                maiorId = getId(t);
            }
        }
        return maiorId + 1;
    }
}