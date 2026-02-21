package com.megaad.inventory.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MarcaResponseDTO {

    private Integer id;
    private String nombre;
    private Boolean activo;
}
