package com.megaad.inventory.service.impl;


import com.megaad.inventory.dto.MovimientoRequestDTO;
import com.megaad.inventory.dto.MovimientoResponseDTO;
import com.megaad.inventory.enums.TipoMovimiento;
import com.megaad.inventory.model.Movimiento;
import com.megaad.inventory.model.Producto;
import com.megaad.inventory.repository.MovimientoRepository;
import com.megaad.inventory.repository.ProductoRepository;
import com.megaad.inventory.service.MovimientoService;
import com.megaad.inventory.util.MovimientoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovimientoServiceImpl implements MovimientoService {

    private final MovimientoRepository movimientoRepository;
    private final ProductoRepository productoRepository;
    private final MovimientoMapper movimientoMapper;

    @Override
    @Transactional
    public MovimientoResponseDTO registrarEntrada(MovimientoRequestDTO dto) {

        Objects.requireNonNull(dto, "El DTO de movimiento no puede ser nulo");
        Objects.requireNonNull(dto.getProductoId(), "El ID del producto no puede ser nulo");
        Objects.requireNonNull(dto.getCantidad(), "La cantidad no puede ser nula");

        if (dto.getCantidad() <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor a cero");
        }

        Producto producto = productoRepository.findById(dto.getProductoId())
                .orElseThrow(() -> new RuntimeException(
                        "El producto con ID " + dto.getProductoId() + " no existe."
                ));
        producto.setStock(
                Optional.ofNullable(producto.getStock()).orElse(0) + dto.getCantidad()
        );
        productoRepository.save(producto);

        return movimientoMapper.toResponse(
                movimientoRepository.save(
                        Movimiento.builder()
                                .producto(producto)
                                .movimiento(TipoMovimiento.ENTRADA)
                                .cantidad(dto.getCantidad())
                                .fecha(LocalDateTime.now())
                                .motivo(dto.getMotivo())
                                .build()
                )
        );
    }
}
