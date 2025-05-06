package com.elektra.prueba.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Data

public class Cliente {

    @Id
    private Long id;

    private String nombre;

    private String correo;

    private String planeta;

    private LocalDate fechaRegistro;

}
