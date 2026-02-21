package com.megaad.inventory.controller;


import com.megaad.inventory.dto.MarcaRequestDTO;
import com.megaad.inventory.dto.MarcaResponseDTO;
import com.megaad.inventory.service.MarcaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/marcas")
@RequiredArgsConstructor
public class MarcaController {

    private final MarcaService marcaService;

    // GET
    @GetMapping
    public ResponseEntity<List<MarcaResponseDTO>> listar() {

        return ResponseEntity.ok(marcaService.obtenerTodas());
    }

    // POST
    @PostMapping
    public ResponseEntity<MarcaResponseDTO> crear(@RequestBody @Valid MarcaRequestDTO dto) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(marcaService.guardar(dto));
    }
}
