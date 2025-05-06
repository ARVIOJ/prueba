package com.elektra.prueba.service;

import com.elektra.prueba.model.Credito;

import java.util.List;

public interface CreditoService {

    Credito guardar(Credito credito);

    Credito obtenerPorId(Long id);

    List<Credito> listar();

    Credito actualizar(Long id, Credito credito);

    void eliminar(Long id);

}
