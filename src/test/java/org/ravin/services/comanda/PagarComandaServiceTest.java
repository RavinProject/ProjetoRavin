package org.ravin.services.comanda;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.ravin.dao.interfaces.IComandaRepositorio;
import org.ravin.models.Cliente;
import org.ravin.models.Comanda;
import org.ravin.models.Pedido;
import org.ravin.models.Produto;
import org.ravin.strategy.interfaces.IDescontoAniversariante;
import org.ravin.strategy.interfaces.IDescontoFactory;
import org.ravin.utils.enums.StatusComanda;
import org.ravin.utils.exceptions.EntidadeNaoEncontradaException;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.ravin.utils.enums.TipoProduto.*;

@ExtendWith(MockitoExtension.class)
public class PagarComandaServiceTest {

    @Mock
    private IDescontoFactory descontoFactory;

    @Mock
    private IComandaRepositorio comandaRepository;

    @Mock
    private IDescontoAniversariante descontoAniversariante;

    @InjectMocks
    private PagarComandaService pagarComandaService;

    private String codigo = "COMANDA1";
    private Comanda comanda;
    private Produto produto;

    @BeforeEach
    public void setup() {
        Cliente mockCliente = new Cliente();
        produto = new Produto(1, "Teste", "Teste", "Produto1", 90.00, 100.00, CARNES);
        Pedido pedido = new Pedido(produto, 1);
        List<Pedido> pedidos = List.of(pedido);

        comanda = new Comanda(mockCliente, codigo);
        comanda.setPedidos(pedidos);

        when(comandaRepository.recuperarComandaPorCodigo(codigo)).thenReturn(Optional.of(comanda));
        when(descontoFactory.criarDescontoAniversariante(any(Cliente.class))).thenReturn(descontoAniversariante);
        when(descontoAniversariante.aplicarDesconto(anyDouble())).thenReturn(100.0);
    }

    @Test
    public void testPagarComanda() throws EntidadeNaoEncontradaException {
        // When
        pagarComandaService.pagarComanda(codigo);
        // Then
        ArgumentCaptor<Comanda> argumentCaptor = ArgumentCaptor.forClass(Comanda.class);
        verify(comandaRepository, times(1)).atualizar(argumentCaptor.capture());

        Comanda capturedComanda = argumentCaptor.getValue();
        assertEquals(StatusComanda.PAGA, capturedComanda.getStatusComanda());
        assertEquals(100.0, capturedComanda.getValorTotalFinal(), 0.01);
    }
}