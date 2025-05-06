package com.elektra.prueba.service;

import com.elektra.prueba.model.Pago;

import java.math.BigDecimal;
import java.util.List;

public interface PagoService {
    Pago guardar(Pago pago);

    Pago obtenerPorId(Long id);

    List<Pago> listar();

    Pago actualizar(Long id, Pago pago);

    void eliminar(Long id);

    BigDecimal obtenerTotalPagadoPorCredito(Long creditoId);

}
