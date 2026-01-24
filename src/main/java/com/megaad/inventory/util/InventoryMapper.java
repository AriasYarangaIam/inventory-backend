package com.megaad.inventory.util;

import com.megaad.inventory.dto.MovimientoResponseDTO;
import com.megaad.inventory.model.Movimiento;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component

public class InventoryMapper {

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
}
