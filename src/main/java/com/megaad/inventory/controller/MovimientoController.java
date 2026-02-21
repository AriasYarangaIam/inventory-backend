package com.megaad.inventory.controller;

import com.megaad.inventory.dto.MovimientoRequestDTO;
import com.megaad.inventory.dto.MovimientoResponseDTO;
import com.megaad.inventory.service.MovimientoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/movimientos")
@RequiredArgsConstructor
public class MovimientoController {

    private final MovimientoService movimientoService;

    @PostMapping("/entrada")
    public ResponseEntity<MovimientoResponseDTO> registrarEntrada(@RequestBody @Valid MovimientoRequestDTO dto) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(movimientoService.registrarEntrada(dto));
    }
    @PostMapping("/salida")
    public ResponseEntity<MovimientoResponseDTO> registrarSalida(@RequestBody @Valid MovimientoRequestDTO dto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(movimientoService.registrarSalida(dto));
    }
    @PostMapping("/ajuste")
    public ResponseEntity<MovimientoResponseDTO> registrarAjuste(@RequestBody @Valid MovimientoRequestDTO dto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(movimientoService.registrarAjuste(dto));
    }
}
