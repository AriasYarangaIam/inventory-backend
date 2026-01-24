package com.megaad.inventory.controller;


import com.megaad.inventory.model.Marca;
import com.megaad.inventory.service.MarcaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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
    public ResponseEntity<List<Marca>> listar() {
        return ResponseEntity.ok(marcaService.obtenerTodas());
    }

    // POST
    @PostMapping
    public ResponseEntity<Marca> crear(@RequestBody Marca marca) {
        Marca nuevaMarca = marcaService.guardar(marca);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaMarca);
    }
}
