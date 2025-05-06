package com.elektra.prueba.mapper;

import com.elektra.prueba.dto.request.ClienteRequest;
import com.elektra.prueba.dto.response.ClienteResponse;
import com.elektra.prueba.model.Cliente;

public class ClienteMapper {

    public static  ClienteResponse toResponse(Cliente cliente) {
        ClienteResponse response = new ClienteResponse();
        response.setId(cliente.getId());
        response.setNombre(cliente.getNombre());
        response.setCorreo(cliente.getCorreo());
        response.setPlaneta(cliente.getPlaneta());
        response.setFechaRegistro(cliente.getFechaRegistro());
        return response;
    }

    public static Cliente toEntity(ClienteRequest request, String planeta) {
        Cliente cliente = new Cliente();
        cliente.setNombre(request.getNombre());
        cliente.setCorreo(request.getCorreo());
        cliente.setPlaneta(planeta);
        cliente.setFechaRegistro(request.getFechaRegistro());
        return cliente;
    }

}
