package com.megaad.inventory.util;

import com.megaad.inventory.dto.MovimientoResponseDTO;
import com.megaad.inventory.model.Movimiento;
import com.megaad.inventory.model.Producto;
import org.springframework.stereotype.Component;

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

    public Movimiento toEntity(MovimientoResponseDTO dto, Producto producto) {
        return Optional.ofNullable(dto)
                .map(d -> Movimiento.builder()
                        .producto(producto)
                        .movimiento(d.getTipoMovimiento())
                        .cantidad(d.getCantidad())
                        .fecha(d.getFecha())
                        .motivo(d.getMotivo())
                        .build())
                .orElse(null);
    }
}
