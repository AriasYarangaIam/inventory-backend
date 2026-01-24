package com.megaad.inventory.controller;

import com.megaad.inventory.dto.MovimientoRequestDTO;
import com.megaad.inventory.dto.MovimientoResponseDTO;
import com.megaad.inventory.model.Movimiento;
import com.megaad.inventory.service.MovimientoService;
import com.megaad.inventory.util.InventoryMapper;
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
    private final InventoryMapper inventoryMapper;

    @PostMapping("/entrada")
    public ResponseEntity<MovimientoResponseDTO> registrarEntrada(@RequestBody @Valid MovimientoRequestDTO dto) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(inventoryMapper.toResponse(
                        movimientoService.registrarEntrada(
                                dto.getProductoId(),
                                dto.getCantidad(),
                                dto.getMotivo()
                        )
                ));
    }
}
