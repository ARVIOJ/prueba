package com.elektra.prueba.service.impl;

import com.elektra.prueba.dto.response.ClienteDetalleResponse;
import com.elektra.prueba.exception.RecursoNoEncontradoException;
import com.elektra.prueba.model.Cliente;
import com.elektra.prueba.repository.ClienteDetalleRepository;
import com.elektra.prueba.repository.ClienteRepository;
import com.elektra.prueba.service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@AllArgsConstructor
@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteDetalleRepository clienteDetalleRepository;

    @Override
    public Cliente guardarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente obtenerClientePorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Cliente con ID " + id + " no encontrado"));
    }

    @Override
    public Iterable<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public void eliminarCliente(Long id) {
        if (!clienteRepository.existsById(id)) {
            throw new RecursoNoEncontradoException("Cliente con ID " + id + " no encontrado");
        }
        clienteRepository.deleteById(id);
    }

    @Override
    public Cliente actualizarCliente(Long id, Cliente cliente) {
        if (!clienteRepository.existsById(id)) {
            throw new RecursoNoEncontradoException("Cliente con ID " + id + " no encontrado");
        }
        cliente.setId(id);
        return clienteRepository.save(cliente);
    }

    @Override
    public List<Cliente> obtenerClientesPorPlaneta(String planeta) {
        return StreamSupport.stream(listarClientes().spliterator(), false)
                .filter(cliente -> cliente.getPlaneta().equalsIgnoreCase(planeta))
                .collect(Collectors.toList());
    }


}
