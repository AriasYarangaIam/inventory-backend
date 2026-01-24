package com.megaad.inventory.service.impl;

import com.megaad.inventory.model.Marca;
import com.megaad.inventory.repository.MarcaRepository;
import com.megaad.inventory.service.MarcaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MarcaServiceImpl implements MarcaService {

    private final MarcaRepository marcaRepository;

    @Override
    public List<Marca> obtenerTodas() {
        return marcaRepository.findAll();
    }

    @Override
    public Marca guardar(Marca marca) {
        if (marca.getNombre() != null) {
            marca.setNombre(marca.getNombre().toUpperCase());
        }
        return marcaRepository.save(marca);
    }
}
