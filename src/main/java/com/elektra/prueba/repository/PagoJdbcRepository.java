package com.elektra.prueba.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public class PagoJdbcRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public BigDecimal obtenerTotalPagado(Long creditoId) {
        String sql = "SELECT * FROM elektra.total_pagado(?)";
        return jdbcTemplate.queryForObject(sql, BigDecimal.class, creditoId);
    }
}
