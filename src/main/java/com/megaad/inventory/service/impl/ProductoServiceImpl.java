package com.megaad.inventory.service.impl;


import com.megaad.inventory.dto.ProductoRequestDTO;
import com.megaad.inventory.dto.ProductoResponseDTO;
import com.megaad.inventory.model.Marca;
import com.megaad.inventory.model.Producto;
import com.megaad.inventory.repository.MarcaRepository;
import com.megaad.inventory.repository.ProductoRepository;
import com.megaad.inventory.service.ProductoService;
import com.megaad.inventory.util.ProductoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;
    private final MarcaRepository marcaRepository;
    private final ProductoMapper productoMapper;

    @Override
    @Transactional(readOnly = true)
    public List<ProductoResponseDTO> obtenerTodos() {
        return productoRepository.findAll()
                .stream()
                .map(productoMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public ProductoResponseDTO guardar(ProductoRequestDTO dto) {

        Objects.requireNonNull(dto, "El DTO de producto no puede ser nulo");
        Objects.requireNonNull(dto.getMarcaId(), "El ID de la marca no puede ser nulo");

        Producto producto = productoMapper.toEntity(dto);

        producto.setMarca(marcaRepository.findById(dto.getMarcaId())
                .orElseThrow(() -> new RuntimeException("La marca con ID " + dto.getMarcaId() + " no existe.")));

        return productoMapper.toResponse(productoRepository.save(producto));
    }
}
