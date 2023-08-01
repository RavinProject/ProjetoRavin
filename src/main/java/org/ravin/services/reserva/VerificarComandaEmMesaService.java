/**
 * Serviço de verificação de comanda em mesa.
 *
 * <p>Este serviço visa verificar se existe alguma comanda vinculada à mesa
 * que está sendo reservada. Este é um passo essencial antes de efetuar qualquer reserva,
 * conforme a regra de negócio RN03.
 *
 * <p>A comanda vinculada à mesa deve estar com posição ABERTA para ser considerada ativa.
 *
 * @see IVerificarComandaEmMesaService
 * @see IComandaRepositorioLista
 */

package org.ravin.services.reserva;

import org.ravin.dao.ListasDados;
import org.ravin.dao.interfaces.IComandaRepositorioLista;
import org.ravin.models.Comanda;
import org.ravin.models.Mesa;
import org.ravin.services.reserva.interfaces.IVerificarComandaEmMesaService;
import org.ravin.utils.enums.StatusComanda;

import java.util.List;

public class VerificarComandaEmMesaService implements IVerificarComandaEmMesaService {

    private final IComandaRepositorioLista comandaRepository;
    public VerificarComandaEmMesaService () { this.comandaRepository = ListasDados.getInstance().getComandaRepositorio(); }


    /**
     * Verifica se há comandas ativas vinculadas a uma mesa.
     *
     * <p>Este método recupera todas as comandas ativas (posição ABERTA) vinculadas a uma mesa.
     * Se a lista de comandas ativas estiver vazia, a mesa está disponível para reserva.
     *
     * @param mesa Mesa para a qual a verificação será realizada.
     * @return true se houver comandas ativas vinculadas à mesa, false caso contrário.
     */
    @Override
    public boolean verificarComandasAbertasEmMesa(Mesa mesa) {
        List<Comanda> comandasAtivas = comandaRepository.recuperarListaPorMesaEStatus(mesa, StatusComanda.ABERTA);
        return !comandasAtivas.isEmpty();
    }

}