package com.megaad.inventory.service;

import com.megaad.inventory.dto.MarcaRequestDTO;
import com.megaad.inventory.dto.MarcaResponseDTO;

import java.util.List;

public interface MarcaService {
    List<MarcaResponseDTO> obtenerTodas();
    MarcaResponseDTO guardar(MarcaRequestDTO marca);
}
