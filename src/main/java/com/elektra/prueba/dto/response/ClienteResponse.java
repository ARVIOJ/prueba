package com.elektra.prueba.dto.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ClienteResponse {
    private Long id;
    private String nombre;
    private String correo;
    private String planeta;
    private LocalDate fechaRegistro;
}
