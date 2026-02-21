package com.megaad.inventory.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "productos", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"marca_id", "producto_modelo", "producto_ancho", "producto_perfil", "producto_rin"})
})
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "producto_id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "marca_id")
    private Marca marca;

    @Column(name = "producto_modelo", nullable = false)
    private String modelo;

    @Column(name = "producto_ancho")
    private Integer ancho;

    @Column(name = "producto_perfil")
    private Integer perfil;

    @Column(name = "producto_rin")
    private Integer rin;

    @Column(name = "producto_precio_costo")
    private BigDecimal precioCosto;

    @Column(name = "precio_venta")
    private BigDecimal precioVenta;

    @Column(name = "stock_actual")
    private Integer stock;

    @Column(name = "producto_estado")
    private Boolean activo;
}
