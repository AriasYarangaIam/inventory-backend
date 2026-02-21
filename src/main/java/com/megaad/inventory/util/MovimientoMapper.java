package com.megaad.inventory.util;

import com.megaad.inventory.dto.MovimientoRequestDTO;
import com.megaad.inventory.dto.MovimientoResponseDTO;
import com.megaad.inventory.enums.TipoMovimiento;
import com.megaad.inventory.model.Movimiento;
import com.megaad.inventory.model.Producto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class MovimientoMapper {

    public MovimientoResponseDTO toResponse(Movimiento movimiento) {
        return Optional.ofNullable(movimiento)
                .map(mov -> MovimientoResponseDTO.builder()
                .movimientoId(mov.getId())
                .productoNombre(mov.getProducto().getModelo())
                .tipoMovimiento(mov.getMovimiento())
                .cantidad(mov.getCantidad())
                .fecha(mov.getFecha())
                .motivo(mov.getMotivo())
                .build())
                .orElseThrow(() -> new RuntimeException("El movimiento entregado es de valor nulo"));
    }

    public Movimiento toEntity(MovimientoRequestDTO dto, Producto producto, TipoMovimiento tipoMovimiento) {
        return Optional.ofNullable(dto)
                .map(d -> Movimiento.builder()
                        .producto(producto)
                        .movimiento(tipoMovimiento)
                        .cantidad(d.getCantidad())
                        .fecha(LocalDateTime.now())
                        .motivo(d.getMotivo())
                        .build())
                .orElse(null);
    }
}
