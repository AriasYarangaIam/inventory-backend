package com.megaad.inventory.service;

import com.megaad.inventory.model.Marca;
import java.util.List;

public interface MarcaService {
    List<Marca> obtenerTodas();
    Marca guardar(Marca marca);
}
