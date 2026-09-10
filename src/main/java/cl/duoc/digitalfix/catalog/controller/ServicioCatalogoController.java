package cl.duoc.digitalfix.catalog.controller;

import cl.duoc.digitalfix.catalog.dto.ActualizarServicioCatalogoRequest;
import cl.duoc.digitalfix.catalog.dto.CrearServicioCatalogoRequest;
import cl.duoc.digitalfix.catalog.dto.ServicioCatalogoResponse;
import cl.duoc.digitalfix.catalog.service.ServicioCatalogoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/catalog/services")
public class ServicioCatalogoController {

    private final ServicioCatalogoService service;

    public ServicioCatalogoController(
            ServicioCatalogoService service) {

        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ServicioCatalogoResponse>> listarTodos() {

        return ResponseEntity.ok(
                service.listarTodos()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServicioCatalogoResponse> buscarPorId(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                service.buscarPorId(id)
        );
    }

    @PostMapping
    public ResponseEntity<ServicioCatalogoResponse> crear(
            @Valid
            @RequestBody CrearServicioCatalogoRequest request) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.crear(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServicioCatalogoResponse> actualizar(
            @PathVariable Long id,
            @Valid
            @RequestBody ActualizarServicioCatalogoRequest request) {

        return ResponseEntity.ok(
                service.actualizar(id, request)
        );
    }
}