package com.megaad.inventory.dto;


import com.megaad.inventory.enums.TipoMovimiento;
import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Builder
public class MovimientoResponseDTO {

    private Integer movimientoId;
    private String productoNombre;
    private TipoMovimiento tipoMovimiento;
    private Integer cantidad;
    private LocalDateTime fecha;
    private String motivo;
}
