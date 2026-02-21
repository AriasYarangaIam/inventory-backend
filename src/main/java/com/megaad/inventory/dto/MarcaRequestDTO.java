package com.megaad.inventory.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MarcaRequestDTO {

    @NotBlank
    @Size(min = 2, max = 100)
    private String nombreMarca;
    @NotNull
    private Boolean activo;
}
