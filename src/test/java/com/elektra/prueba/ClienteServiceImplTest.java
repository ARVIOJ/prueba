package com.elektra.prueba;

import com.elektra.prueba.model.Cliente;
import com.elektra.prueba.repository.ClienteDetalleRepository;
import com.elektra.prueba.repository.ClienteRepository;
import com.elektra.prueba.service.SwapiService;
import com.elektra.prueba.service.impl.ClienteServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ClienteServiceImplTest {

    private ClienteRepository clienteRepository;
    private ClienteServiceImpl clienteService;
    private ClienteDetalleRepository clienteDetalleRepository;

    @BeforeEach
    void setUp() {
        clienteRepository = mock(ClienteRepository.class);
        clienteDetalleRepository = mock(ClienteDetalleRepository.class);
        clienteService = new ClienteServiceImpl(clienteRepository, clienteDetalleRepository);
    }

    @Test
    void guardarCliente_deberiaGuardarYRetornarCliente() {
        Cliente cliente = new Cliente();
        cliente.setNombre("Luke");
        cliente.setCorreo("luke@rebelsss.org");
        cliente.setPlaneta("Tatooine");
        cliente.setFechaRegistro(LocalDate.now());

        when(clienteRepository.save(cliente)).thenReturn(cliente);

        Cliente resultado = clienteService.guardarCliente(cliente);

        assertEquals("Luke", resultado.getNombre());
        verify(clienteRepository).save(cliente);
    }

    @Test
    void obtenerClientePorId_deberiaRetornarCliente() {
        Cliente cliente = new Cliente();
        cliente.setId(1L);
        cliente.setNombre("Leia");

        when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));

        Cliente resultado = clienteService.obtenerClientePorId(1L);

        assertNotNull(resultado);
        assertEquals("Leia", resultado.getNombre());
    }
}
