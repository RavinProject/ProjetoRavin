package org.ravin.services.comanda;

import org.ravin.dao.interfaces.IComandaRepositorio;
import org.ravin.models.Cliente;
import org.ravin.models.Comanda;
import org.ravin.services.comanda.interfaces.IPagarComandaService;
import org.ravin.strategy.interfaces.IDescontoAniversariante;
import org.ravin.strategy.interfaces.IDescontoFactory;
import org.ravin.utils.exceptions.EntidadeNaoEncontradaException;

import java.util.Optional;

import static org.ravin.utils.enums.StatusComanda.PAGA;

public class PagarComandaService implements IPagarComandaService {

    private final IComandaRepositorio comandaRepository;
    private final IDescontoFactory descontoFactory;

    public PagarComandaService(IComandaRepositorio comandaRepository, IDescontoFactory descontoFactory) {
        this.comandaRepository = comandaRepository;
        this.descontoFactory = descontoFactory;
    }

    /**
     * Paga a comanda com o código fornecido,
     * chamando a classe de descontos aplicando a regra do desconto
     * por aniversário.
     *
     * @param codigo da comanda a ser paga
     * @return true se bem-sucedido
     * @throws EntidadeNaoEncontradaException Se a comanda com o código fornecido não for encontrada.
     */
    public boolean pagarComanda(String codigo) throws EntidadeNaoEncontradaException {
        Optional<Comanda> oComanda = comandaRepository.recuperarComandaPorCodigo(codigo);
        if(oComanda.isPresent()) {
            Comanda comanda = oComanda.get();
            Cliente cliente = comanda.getCliente();

            IDescontoAniversariante descontoAniversariante = descontoFactory.criarDescontoAniversariante(cliente);
            double novoTotal = processarComanda(comanda, descontoAniversariante);
            comanda.setStatusComanda(PAGA);
            comanda.setValorTotalFinal(novoTotal);
            comandaRepository.atualizar(comanda);
            return true;
            // TODO implementar liberação de mesa em futura iteração
        } else {
            throw new EntidadeNaoEncontradaException("Comanda com o código " + codigo + " não encontrada.");
        }
    }

    // Método privado que recebe a estratégia de desconto
    private double processarComanda(Comanda comanda, IDescontoAniversariante desconto) {
        double valorTotal = comanda.getValorTotalProdutos();
        return desconto.aplicarDesconto(valorTotal);
    }
}
