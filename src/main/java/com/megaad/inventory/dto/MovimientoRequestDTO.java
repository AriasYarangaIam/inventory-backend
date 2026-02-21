package com.megaad.inventory.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovimientoRequestDTO {

    @NotNull
    private Integer productoId;
    @NotNull
    @Min(value = 0)
    private Integer cantidad;
    @NotBlank
    private String motivo;
    @NotNull
    @Positive
    private BigDecimal precioUnitario;

}
