package com.megaad.inventory.controller;


import com.megaad.inventory.dto.ProductoRequestDTO;
import com.megaad.inventory.dto.ProductoResponseDTO;
import com.megaad.inventory.service.ProductoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService productoService;

    @GetMapping
    public ResponseEntity<List<ProductoResponseDTO>> listar() {
        return ResponseEntity
                .ok(productoService.obtenerTodos());
    }

    @PostMapping
    public ResponseEntity<ProductoResponseDTO> crear(@RequestBody @Valid ProductoRequestDTO dto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(productoService.guardar(dto));
    }
}
