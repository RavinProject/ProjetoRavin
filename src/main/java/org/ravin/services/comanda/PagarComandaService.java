/**
 * Serviço para pagamento de comandas.
 *
 * <p>Este serviço é responsável pelo pagamento de uma comanda, identificada por seu código. O pagamento inclui
 * a aplicação de possíveis descontos ao total bruto da comanda, com base em regras predefinidas.
 *
 * <p>Atualmente, é aplicada uma regra de desconto para aniversariantes.
 *
 * @see IPagarComandaService
 * @see IComandaRepositorioLista
 * @see IDescontoFactory
 */

package org.ravin.services.comanda;

import org.ravin.dao.interfaces.IComandaRepositorioLista;
import org.ravin.models.Cliente;
import org.ravin.models.Comanda;
import org.ravin.services.comanda.interfaces.IPagarComandaService;
import org.ravin.strategy.interfaces.IDescontoAniversariante;
import org.ravin.strategy.interfaces.IDescontoFactory;
import org.ravin.utils.exceptions.EntidadeNaoEncontradaException;

import java.util.Optional;

import static org.ravin.utils.enums.StatusComanda.PAGA;

public class PagarComandaService implements IPagarComandaService {

    private final IComandaRepositorioLista comandaRepository;
    private final IDescontoFactory descontoFactory;

    /**
     * Construtor do serviço.
     *
     * <p>Recebe uma instância de {@code IComandaRepositorioLista} para acessar o repositório de comandas,
     * e uma instância de {@code IDescontoFactory} para criar a regra de desconto aplicada.
     *
     * @param comandaRepository o repositório de comandas
     * @param descontoFactory a fábrica de regras de desconto
     */
    public PagarComandaService(IComandaRepositorioLista comandaRepository, IDescontoFactory descontoFactory) {
        this.comandaRepository = comandaRepository;
        this.descontoFactory = descontoFactory;
    }

    /**
     * Paga uma comanda e aplica um desconto de aniversariante, se aplicável.
     *
     * <p>Este método recupera a comanda pelo seu código, aplica a regra de desconto para aniversariantes
     * ao total bruto da comanda, atualiza o status e o total líquido da comanda, e finalmente salva a comanda.
     *
     * @param codigo o código da comanda a ser paga
     * @throws EntidadeNaoEncontradaException se a comanda com o código fornecido não for encontrada
     */
    public void pagarComanda(String codigo) throws EntidadeNaoEncontradaException {
        Optional<Comanda> oComanda = comandaRepository.recuperarComandaPorCodigo(codigo);
        if(oComanda.isPresent()) {
            Comanda comanda = oComanda.get();
            Cliente cliente = comanda.getCliente();

            IDescontoAniversariante descontoAniversariante = descontoFactory.criarDescontoAniversariante(cliente);
            double novoTotal = processarComanda(comanda, descontoAniversariante);
            comanda.setStatusComanda(PAGA);
            comanda.setTotalLiquido(novoTotal);
            comandaRepository.atualizar(comanda);
            // TODO implementar liberação de mesa em futura iteração
        } else {
            throw new EntidadeNaoEncontradaException("Comanda com o código " + codigo + " não encontrada.");
        }
    }

    /**
     * Aplica a regra de desconto ao total bruto da comanda.
     *
     * <p>Este método privado é utilizado internamente para encapsular a lógica de aplicação de descontos.
     *
     * @param comanda a comanda a ser processada
     * @param desconto a regra de desconto a ser aplicada
     * @return o novo total líquido da comanda após a aplicação do desconto
     */
    private double processarComanda(Comanda comanda, IDescontoAniversariante desconto) {
        double valorTotal = comanda.getTotalBruto();
        return desconto.aplicarDesconto(valorTotal);
    }
}
