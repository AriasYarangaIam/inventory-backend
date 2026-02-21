package com.megaad.inventory.service;

import com.megaad.inventory.dto.ProductoRequestDTO;
import com.megaad.inventory.dto.ProductoResponseDTO;

import java.util.List;

public interface ProductoService {
    List<ProductoResponseDTO> obtenerTodos();
    ProductoResponseDTO guardar(ProductoRequestDTO dto);
}
