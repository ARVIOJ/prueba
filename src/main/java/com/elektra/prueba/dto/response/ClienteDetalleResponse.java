package com.elektra.prueba.dto.response;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ClienteDetalleResponse {
    private Long clienteId;
    private String nombre;
    private String correo;
    private String planeta;
    private LocalDate fechaRegistro;

    private Long creditoId;
    private BigDecimal monto;
    private BigDecimal tasaInteres;
    private String estado;
    private LocalDate fechaCreacion;

    private Long pagoId;
    private BigDecimal montoPagado;
    private LocalDateTime fechaPago;
}
