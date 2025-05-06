package com.elektra.prueba.repository;

import com.elektra.prueba.dto.response.ClienteDetalleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClienteDetalleRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<ClienteDetalleResponse> obtenerDetallesPorClienteId(Long clienteId) {
        String sql = "SELECT * FROM obtener_detalles_cliente(?)";

        return jdbcTemplate.query(sql, new Object[]{clienteId}, (rs, rowNum) -> {
            ClienteDetalleResponse dto = new ClienteDetalleResponse();
            dto.setClienteId(rs.getLong("cliente_id"));
            dto.setNombre(rs.getString("nombre"));
            dto.setCorreo(rs.getString("correo"));
            dto.setPlaneta(rs.getString("planeta"));
            dto.setFechaRegistro(rs.getDate("fecha_registro").toLocalDate());

            dto.setCreditoId(rs.getLong("credito_id"));
            dto.setMonto(rs.getBigDecimal("monto"));
            dto.setTasaInteres(rs.getBigDecimal("tasa_interes"));
            dto.setEstado(rs.getString("estado"));
            dto.setFechaCreacion(rs.getDate("fecha_creacion") != null ? rs.getDate("fecha_creacion").toLocalDate() : null);

            dto.setPagoId(rs.getLong("pago_id"));
            dto.setMontoPagado(rs.getBigDecimal("monto_pagado"));
            dto.setFechaPago(rs.getTimestamp("fecha_pago") != null ? rs.getTimestamp("fecha_pago").toLocalDateTime() : null);

            return dto;
        });
    }
}
