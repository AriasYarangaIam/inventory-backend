package com.megaad.inventory.service;

import com.megaad.inventory.model.Producto;
import java.util.List;

public interface ProductoService {
    List<Producto> obtenerTodos();
    Producto guardar(Producto producto);
}
