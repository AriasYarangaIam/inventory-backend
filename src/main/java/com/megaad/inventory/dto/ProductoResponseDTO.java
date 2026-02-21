package com.megaad.inventory.dto;

import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Builder
public class ProductoResponseDTO {

    private Integer id;
    private String modelo;
    private String marcaNombre;
    private Integer ancho;
    private Integer perfil;
    private Integer rin;
    private BigDecimal precioVenta;
    private Integer stock;
    private Boolean activo;
}
