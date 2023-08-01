package org.ravin.services.reserva.interfaces;

import org.ravin.models.Mesa;

public interface IVerificarComandaEmMesaService {
    boolean verificarComandasAbertasEmMesa(Mesa mesa);
}
