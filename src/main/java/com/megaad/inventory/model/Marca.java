package com.megaad.inventory.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "marcas")
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "marca_id")
    private Integer id;

    @Column(name = "marca_nombre", nullable = false, unique = true, length = 100)
    private String nombre;

    @Column(name = "marca_estado")
    private Boolean activo;

}
