package com.megaad.inventory.service.impl;

import com.megaad.inventory.dto.MarcaRequestDTO;
import com.megaad.inventory.dto.MarcaResponseDTO;
import com.megaad.inventory.model.Marca;
import com.megaad.inventory.repository.MarcaRepository;
import com.megaad.inventory.service.MarcaService;
import com.megaad.inventory.util.MarcaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MarcaServiceImpl implements MarcaService {

    private final MarcaRepository marcaRepository;
    private final MarcaMapper marcaMapper;

    @Override
    @Transactional(readOnly = true)
    public List<MarcaResponseDTO> obtenerTodas() {
        return marcaRepository
                .findAll()
                .stream()
                .map(marcaMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public MarcaResponseDTO guardar(MarcaRequestDTO dto) {
        Objects.requireNonNull(dto);

        Marca marca = marcaMapper.toEntity(dto);

        String nombreNormalizado = Optional.ofNullable(marca.getNombre())
                .map(String::toUpperCase)
                .orElseThrow(() -> new IllegalArgumentException(
                        "El nombre de la marca no pueder ser nulo"));

        if (marcaRepository.existsByNombre(nombreNormalizado)) {
            return null;
        }
        marca.setNombre(nombreNormalizado);

        Marca marcaGuardada = marcaRepository.save(marca);
        return marcaMapper.toResponse(marcaGuardada);
    }
}
