package com.losAtuendos.los_atuendos_ucompensar.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "lavanderia_registro")
public class LavanderiaRegistro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer prendaRef;

    @Column(nullable = false)
    private boolean prioridad;

    @Column(nullable = false)
    private String estado = "pendiente";

    public LavanderiaRegistro(Integer prendaRef, boolean prioridad) {
        this.prendaRef = prendaRef;
        this.prioridad = prioridad;
    }
}