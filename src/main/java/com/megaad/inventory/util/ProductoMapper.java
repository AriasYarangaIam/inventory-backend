package com.megaad.inventory.util;

import com.megaad.inventory.dto.ProductoRequestDTO;
import com.megaad.inventory.dto.ProductoResponseDTO;
import com.megaad.inventory.model.Marca;
import com.megaad.inventory.model.Producto;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProductoMapper {

    public ProductoResponseDTO toResponse(Producto producto) {
        return Optional.ofNullable(producto)
                .map(pro -> ProductoResponseDTO.builder()
                        .id(pro.getId())
                        .modelo(pro.getModelo())
                        .marcaNombre(
                                Optional.ofNullable(pro.getMarca())
                                        .map(Marca::getNombre)
                                        .orElse("Sin Marca")
                        )
                        .ancho(pro.getAncho())
                        .perfil(pro.getPerfil())
                        .rin(pro.getRin())
                        .precioVenta(pro.getPrecioVenta())
                        .stock(pro.getStock())
                        .build()).orElse(null);
    }

    public Producto toEntity(ProductoRequestDTO dto) {
        return Optional.ofNullable(dto)
                .map(d -> Producto.builder()
                        .modelo(d.getModelo())
                        .ancho(d.getAncho())
                        .perfil(d.getPerfil())
                        .rin(d.getRin())
                        .precioCosto(d.getPrecioCosto())
                        .precioVenta(d.getPrecioVenta())
                        .stock(d.getStock())
                        .build())
                .orElse(null);
    }

}
