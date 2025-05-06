package com.elektra.prueba.service.impl;

import com.elektra.prueba.dto.response.ClienteDetalleResponse;
import com.elektra.prueba.service.ClienteDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteDetalleServiceImpl implements ClienteDetalleService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<ClienteDetalleResponse> obtenerDetalles(Long clienteId) {
        String sql = "SELECT * FROM elektra.obtener_detalles_cliente(?)";

        return jdbcTemplate.query(
                sql,
                new Object[]{clienteId},
                (rs, rowNum) -> {
                    ClienteDetalleResponse response = new ClienteDetalleResponse();
                    response.setClienteId(rs.getLong("id"));
                    response.setNombre(rs.getString("nombre"));
                    response.setCorreo(rs.getString("correo"));
                    response.setPlaneta(rs.getString("planeta"));
                    response.setFechaRegistro(rs.getDate("fecha_registro").toLocalDate());
                    response.setMontoPagado(rs.getBigDecimal("total_pagado"));
                    return response;
                }
        );
    }
}
