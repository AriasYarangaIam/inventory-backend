package com.megaad.inventory.model;


import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "producto_id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "marca_id")
    private Marca marca;

    @Transient
    private Integer marcaId;

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
}
