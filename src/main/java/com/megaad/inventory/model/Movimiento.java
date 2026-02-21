package com.megaad.inventory.model;


import com.megaad.inventory.enums.TipoMovimiento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "movimientos_inventario")
public class Movimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movimiento_inventario_id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producto_id")
    private Producto producto;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_movimiento")
    private TipoMovimiento movimiento;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "fecha_hora")
    private LocalDateTime fecha;

    @Column(name = "motivo")
    private String motivo;

    @Column(name = "precio_unitario")
    private BigDecimal precioUnitario;
}
