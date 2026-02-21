package com.megaad.inventory.util;

import com.megaad.inventory.dto.MarcaRequestDTO;
import com.megaad.inventory.dto.MarcaResponseDTO;
import com.megaad.inventory.model.Marca;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MarcaMapper {

    public MarcaResponseDTO toResponse(Marca marca) {
        return Optional.ofNullable(marca)
                .map(m -> MarcaResponseDTO.builder()
                        .id(m.getId())
                        .nombre(m.getNombre())
                        .activo(m.getActivo())
                        .build())
                .orElse(null);
    }

    public Marca toEntity(MarcaRequestDTO dto) {
        return Optional.ofNullable(dto)
                .map(d -> Marca.builder()
                        .nombre(d.getNombreMarca())
                        .activo(d.getActivo())
                        .build())
                .orElse(null);
    }
}
