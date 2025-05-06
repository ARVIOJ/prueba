package com.elektra.prueba.service;

import com.elektra.prueba.dto.response.ClienteDetalleResponse;

import java.util.List;

public interface ClienteDetalleService {
    List<ClienteDetalleResponse> obtenerDetalles(Long clienteId);
}
