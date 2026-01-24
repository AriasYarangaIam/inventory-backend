package com.megaad.inventory.service.impl;


import com.megaad.inventory.enums.TipoMovimiento;
import com.megaad.inventory.model.Movimiento;
import com.megaad.inventory.model.Producto;
import com.megaad.inventory.repository.MovimientoRepository;
import com.megaad.inventory.repository.ProductoRepository;
import com.megaad.inventory.service.MovimientoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovimientoServiceImpl implements MovimientoService {

    private final MovimientoRepository movimientoRepository;
    private final ProductoRepository productoRepository;

    @Override
    @Transactional
    public Movimiento registrarEntrada(Integer id, Integer cantidad, String motivo) {


        if (id == null) {throw new RuntimeException("ERROR: Debe de existir el ID del producto");}

        Producto producto = productoRepository.findById(id)
                .orElseThrow(() ->
                   new RuntimeException("ERROR: El producto con ID " + id + " no existe"));

        int stockActual = producto.getStock() == null ? 0 : producto.getStock();
        producto.setStock(stockActual + cantidad);
        productoRepository.save(producto);

        Movimiento movimiento = new Movimiento();
        movimiento.setProducto(producto);
        movimiento.setMovimiento(TipoMovimiento.ENTRADA);
        movimiento.setCantidad(cantidad);
        movimiento.setFecha(LocalDateTime.now());
        movimiento.setMotivo(motivo);
        
        return movimientoRepository.save(movimiento);
    }
}
