package org.ravin.dao.interfaces;

import org.ravin.models.Estoque;
import org.ravin.utils.interfaces.IGeradorId;

import java.util.Optional;

public interface IEstoqueRepositorioLista extends IRepositorioLista<Estoque>, IGeradorId<Estoque> {
    Optional<Estoque> recuperarEstoquePorCodigo(String codigo) ;
    default int getId(Estoque estoque){
        return estoque.getId();
    }
}
