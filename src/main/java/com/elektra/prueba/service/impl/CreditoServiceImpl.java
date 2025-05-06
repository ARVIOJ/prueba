package com.elektra.prueba.service.impl;

import com.elektra.prueba.model.Credito;
import com.elektra.prueba.repository.CreditoRepository;
import com.elektra.prueba.service.CreditoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CreditoServiceImpl implements CreditoService {

    @Autowired
    private CreditoRepository creditoRepository;

    @Override
    public Credito guardar(Credito credito) {
        return creditoRepository.save(credito);
    }

    @Override
    public Credito obtenerPorId(Long id) {
        return creditoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Credito> listar() {
        List<Credito> lista = new ArrayList<>();
        creditoRepository.findAll().forEach(lista::add);
        return lista;
    }

    @Override
    public Credito actualizar(Long id, Credito credito) {
        if (!creditoRepository.existsById(id)) return null;
        credito.setId(id);
        return creditoRepository.save(credito);
    }

    @Override
    public void eliminar(Long id) {
        creditoRepository.deleteById(id);
    }
}
