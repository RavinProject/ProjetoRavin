package org.ravin.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.ravin.dao.ComandaRepositorio;
import org.ravin.models.Cliente;
import org.ravin.models.Comanda;
import org.ravin.utils.enums.StatusComanda;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ComandaServiceTest {

    private ComandaService comandaService;
    private ComandaRepositorio comandaRepositorio;
    private final String CODIGO_VALIDO = "CODIGO_VALIDO";
    private final String CODIGO_INVALIDO = "CODIGO_INVALIDO";

    @BeforeEach
    void setUp() {
        comandaRepositorio = mock(ComandaRepositorio.class);
        comandaService = new ComandaService(comandaRepositorio);
    }

    @Test
    void testFecharComandaValid() {
        Cliente cliente = new Cliente(1, "Daniele Felicio", "04798456233", "003665782047", true);
        Comanda comanda = new Comanda(cliente, CODIGO_VALIDO);

        when(comandaRepositorio.getComandaPorCodigo(CODIGO_VALIDO)).thenReturn(comanda);
        assertTrue(comandaService.fecharComanda(CODIGO_VALIDO));
        assertEquals(StatusComanda.FECHADA, comanda.getStatusComanda());
        verify(comandaRepositorio, times(1)).inserir(comanda);
    }

    @Test
    void testFecharComandaInvalid() {
        when(comandaRepositorio.getComandaPorCodigo(CODIGO_INVALIDO)).thenReturn(null);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            comandaService.fecharComanda(CODIGO_INVALIDO);
        });

        assertEquals("Comanda com o código " + CODIGO_INVALIDO + " não encontrada.", exception.getMessage());
    }
}
