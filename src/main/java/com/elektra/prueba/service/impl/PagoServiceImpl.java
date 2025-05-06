package com.elektra.prueba.service.impl;

import com.elektra.prueba.model.Pago;
import com.elektra.prueba.repository.PagoJdbcRepository;
import com.elektra.prueba.repository.PagoRepository;
import com.elektra.prueba.service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class PagoServiceImpl implements PagoService {

    @Autowired
    private PagoRepository pagoRepository;

    @Autowired
    private PagoJdbcRepository pagoJdbcRepository;

    @Override
    public Pago guardar(Pago pago) {
        return pagoRepository.save(pago);
    }

    @Override
    public Pago obtenerPorId(Long id) {
        return pagoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Pago> listar() {
        List<Pago> lista = new ArrayList<>();
        pagoRepository.findAll().forEach(lista::add);
        return lista;
    }

    @Override
    public Pago actualizar(Long id, Pago pago) {
        if (!pagoRepository.existsById(id)) return null;
        pago.setId(id);
        return pagoRepository.save(pago);
    }

    @Override
    public void eliminar(Long id) {
        pagoRepository.deleteById(id);
    }

    @Override
    public BigDecimal obtenerTotalPagadoPorCredito(Long creditoId) {
        return pagoJdbcRepository.obtenerTotalPagado(creditoId);
    }

}
