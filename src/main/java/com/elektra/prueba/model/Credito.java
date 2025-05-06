package com.elektra.prueba.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Data
public class Credito {
    @Id
    private Long id;
    private Long clienteId;
    private Double monto;
    private Double tasaInteres;
    private String estado;
    private LocalDate fechaCreacion;
}
