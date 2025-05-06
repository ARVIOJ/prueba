package com.elektra.prueba.controller;

import com.elektra.prueba.model.Pago;
import com.elektra.prueba.service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/v1/pagos")
public class PagoController {

    @Autowired
    private PagoService pagoService;

    @PostMapping
    public ResponseEntity<Pago> guardar(@RequestBody Pago pago) {
        return ResponseEntity.ok(pagoService.guardar(pago));
    }

    @GetMapping
    public ResponseEntity<List<Pago>> listar() {
        return ResponseEntity.ok(pagoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pago> obtenerPorId(@PathVariable Long id) {
        Pago pago = pagoService.obtenerPorId(id);
        if (pago == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(pago);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pago> actualizar(@PathVariable Long id, @RequestBody Pago pago) {
        Pago actualizado = pagoService.actualizar(id, pago);
        if (actualizado == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        pagoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/total/{creditoId}")
    public ResponseEntity<BigDecimal> obtenerTotalPagado(@PathVariable Long creditoId) {
        BigDecimal total = pagoService.obtenerTotalPagadoPorCredito(creditoId);
        return ResponseEntity.ok(total);
    }

}
