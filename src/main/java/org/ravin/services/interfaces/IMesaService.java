package org.ravin.services.interfaces;

import org.ravin.models.Mesa;

import java.util.Optional;

public interface IMesaService extends IService<Mesa>{
    Optional<Mesa> recuperarPorCodigo(String codigo);
}
