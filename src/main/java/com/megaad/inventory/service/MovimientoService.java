package com.megaad.inventory.service;

import com.megaad.inventory.dto.MovimientoRequestDTO;
import com.megaad.inventory.dto.MovimientoResponseDTO;

public interface MovimientoService {
    MovimientoResponseDTO registrarEntrada(MovimientoRequestDTO dto);
}
