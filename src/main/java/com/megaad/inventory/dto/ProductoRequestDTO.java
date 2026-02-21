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
public class ProductoRequestDTO {

    @NotBlank
    private String modelo;
    @NotNull
    @Positive
    private Integer marcaId;
    @NotNull
    @Positive
    private Integer ancho;
    @NotNull
    @Positive
    private Integer perfil;
    @NotNull
    @Positive
    private Integer rin;
    @NotNull
    @Positive
    private BigDecimal precioCosto;
    @NotNull
    @Positive
    private BigDecimal precioVenta;
    @NotNull
    @Min(value = 0)
    private Integer stock;
}
