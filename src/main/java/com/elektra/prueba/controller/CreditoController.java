package com.elektra.prueba.controller;

import com.elektra.prueba.model.Credito;
import com.elektra.prueba.service.CreditoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/creditos")
public class CreditoController {

    @Autowired
    private CreditoService creditoService;

    @PostMapping
    public ResponseEntity<Credito> guardar(@RequestBody Credito credito) {
        return ResponseEntity.ok(creditoService.guardar(credito));
    }

    @GetMapping
    public ResponseEntity<List<Credito>> listar() {
        return ResponseEntity.ok(creditoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Credito> obtenerPorId(@PathVariable Long id) {
        Credito credito = creditoService.obtenerPorId(id);
        if (credito == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(credito);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Credito> actualizar(@PathVariable Long id, @RequestBody Credito credito) {
        Credito actualizado = creditoService.actualizar(id, credito);
        if (actualizado == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        creditoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

}
