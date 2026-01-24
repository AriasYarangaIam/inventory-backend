package com.megaad.inventory.service.impl;


import com.megaad.inventory.model.Marca;
import com.megaad.inventory.model.Producto;
import com.megaad.inventory.repository.MarcaRepository;
import com.megaad.inventory.repository.ProductoRepository;
import com.megaad.inventory.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;
    private final MarcaRepository marcaRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Producto> obtenerTodos() {
        return productoRepository.findAll();
    }

    @Override
    @Transactional
    public Producto guardar(Producto producto) {

        if (producto.getMarcaId() == null) {
            throw new RuntimeException("ERROR: Debes especificar el ID de la marca.");
        }

        Marca marca = marcaRepository.findById(producto.getMarcaId())
                .orElseThrow(() -> new RuntimeException("ERROR: La marca con ID " + producto.getMarcaId() + " no existe."));

        producto.setMarca(marca);

        return productoRepository.save(producto);
    }
}
