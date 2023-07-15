package services.comanda;

import dao.ComandaRepositorio;
import dao.interfaces.IComandaRepositorio;
import models.Cliente;
import models.Comanda;
import strategy.interfaces.IDescontoAniversariante;
import strategy.interfaces.IDescontoFactory;
import utils.enums.StatusComanda;
import utils.exceptions.EntidadeNaoEncontradaException;

import java.util.Optional;

public class PagarComandaService implements IPagarComandaService {
    private final IComandaRepositorio comandaRepository;
    private final IDescontoFactory descontoFactory;

    public PagarComandaService(IDescontoFactory descontoFactory) {
        this.comandaRepository = new ComandaRepositorio();
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
        Optional<Comanda> oComanda = comandaRepository.getComandaPorCodigo(codigo);
        if(oComanda.isPresent()) {
            Comanda comanda = oComanda.get();
            Cliente cliente = comanda.getCliente();

            IDescontoAniversariante descontoAniversariante = descontoFactory.criarDescontoAniversariante(cliente);
            double novoTotal = processarComanda(comanda, descontoAniversariante);

            comanda.setValorTotalFinal(novoTotal);
            comanda.setStatusComanda(StatusComanda.PAGA);
            comandaRepository.inserir(comanda);
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
