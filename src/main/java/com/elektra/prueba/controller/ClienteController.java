package com.elektra.prueba.controller;

import com.elektra.prueba.dto.request.ClienteRequest;
import com.elektra.prueba.dto.response.ClienteDetalleResponse;
import com.elektra.prueba.dto.response.ClienteResponse;
import com.elektra.prueba.exception.RecursoNoEncontradoException;
import com.elektra.prueba.mapper.ClienteMapper;
import com.elektra.prueba.model.Cliente;
import com.elektra.prueba.service.ClienteDetalleService;
import com.elektra.prueba.service.ClienteService;
import com.elektra.prueba.service.SwapiService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.StreamSupport;

import static com.elektra.prueba.mapper.ClienteMapper.*;

@RestController
@RequestMapping("/v1/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private SwapiService swapiService;

    @Autowired
    private ClienteDetalleService clienteDetalleService;

    @PostMapping
    public ResponseEntity<ClienteResponse> guardar(@Valid @RequestBody ClienteRequest clienteReq) {
        String planetaAleatorio = swapiService.obtenerPlanetaAleatorio();

        Cliente cliente = toEntity(clienteReq, planetaAleatorio);
        Cliente guardado = clienteService.guardarCliente(cliente);
        return ResponseEntity.ok(toResponse(guardado));
    }

    @Operation(summary = "Obtener todos los clientes")
    @GetMapping
    public ResponseEntity<List<ClienteResponse>> listar() {
        List<ClienteResponse> clientes = StreamSupport
                .stream(clienteService.listarClientes().spliterator(), false)
                .map(ClienteMapper::toResponse)
                .toList();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponse> obtenerPorId(@PathVariable Long id) {
        Cliente cliente = clienteService.obtenerClientePorId(id);
        if (cliente == null) {
            throw new RecursoNoEncontradoException("Cliente no encontrado con ID: " + id);
        }
        return ResponseEntity.ok(toResponse(cliente));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponse> actualizar(@PathVariable Long id, @Valid @RequestBody ClienteRequest clienteReq) {
        Cliente existente = clienteService.obtenerClientePorId(id);
        if (existente == null) {
            throw new RecursoNoEncontradoException("Cliente no encontrado con ID: " + id);
        }

        existente.setNombre(clienteReq.getNombre());
        existente.setCorreo(clienteReq.getCorreo());
        existente.setFechaRegistro(clienteReq.getFechaRegistro());

        Cliente actualizado = clienteService.actualizarCliente(id, existente);
        return ResponseEntity.ok(toResponse(actualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        clienteService.eliminarCliente(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/planeta/{planeta}")
    public ResponseEntity<List<ClienteResponse>> obtenerPorPlaneta(@PathVariable String planeta) {
        List<Cliente> clientes = clienteService.obtenerClientesPorPlaneta(planeta);
        if (clientes.isEmpty()) {
            throw new RecursoNoEncontradoException("No se encontraron clientes en el planeta: " + planeta);
        }

        List<ClienteResponse> respuesta = clientes.stream()
                .map(ClienteMapper::toResponse)
                .toList();

        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/{id}/detalles")
    public ResponseEntity<List<ClienteDetalleResponse>> obtenerDetalles(@PathVariable Long id) {
        List<ClienteDetalleResponse> detalles = clienteDetalleService.obtenerDetalles(id);
        if (detalles.isEmpty()) {
            throw new RecursoNoEncontradoException("No se encontró información del cliente con ID: " + id);
        }
        return ResponseEntity.ok(detalles);
    }
}
