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

    @ManyToOne(optional = false)
    @JoinColumn(name = "prenda_id", nullable = false)
    private Prenda prenda;

    @Column(nullable = false)
    private boolean prioridad;

    @Column(nullable = false)
    private String estado = "pendiente";

    public LavanderiaRegistro(Prenda prenda, boolean prioridad) {
        this.prenda = prenda;
        this.prioridad = prioridad;
    }
}