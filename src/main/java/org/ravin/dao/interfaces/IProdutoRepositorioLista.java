package org.ravin.dao.interfaces;

import org.ravin.models.Produto;
import org.ravin.utils.interfaces.IGeradorId;

import java.util.Optional;

public interface IProdutoRepositorioLista extends IRepositorioLista<Produto>, IGeradorId<Produto> {
    Optional<Produto> recuperarProdutoPorCodigo(String codigo) ;

    default int getId(Produto produto){
        return produto.getId();
    }
}
