package com.megaad.inventory.service;

import com.megaad.inventory.model.Movimiento;

public interface MovimientoService {
    Movimiento registrarEntrada(Integer id, Integer cantidad, String motivo);
}
