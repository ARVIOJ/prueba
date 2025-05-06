package com.elektra.prueba.model;

import lombok.Data;

import java.time.LocalDateTime;
import org.springframework.data.annotation.Id;

@Data
public class Pago {
    @Id
    private Long id;
    private Long creditoId;
    private Double montoPagado;
    private LocalDateTime fechaPago;
}
