package com.elektra.prueba.service;

import com.elektra.prueba.dto.response.ClienteDetalleResponse;
import com.elektra.prueba.model.Cliente;

import java.util.List;

public interface ClienteService {

    Cliente guardarCliente(Cliente cliente);

    Cliente obtenerClientePorId(Long id);

    Iterable<Cliente> listarClientes();

    void eliminarCliente(Long id);

    Cliente actualizarCliente(Long id, Cliente cliente);

    List<Cliente> obtenerClientesPorPlaneta(String planeta);

}
