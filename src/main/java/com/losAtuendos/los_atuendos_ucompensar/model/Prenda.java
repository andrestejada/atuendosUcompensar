package com.losAtuendos.los_atuendos_ucompensar.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@MappedSuperclass
public abstract class Prenda {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer ref;
    private String color;
    private String marca;
    private String talla;
    private double valorAlquiler;

    public Prenda(Integer ref ,String color,  String marca, String talla, double valorAlquiler) {
        this.ref = ref;
        this.color = color;
        this.marca = marca;
        this.talla = talla;
        this.valorAlquiler = valorAlquiler;
    }
}
