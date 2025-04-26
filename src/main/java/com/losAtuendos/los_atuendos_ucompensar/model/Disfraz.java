package com.losAtuendos.los_atuendos_ucompensar.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("DISFRAZ")
@Data
public class Disfraz extends Prenda {
    private String nombre;

    public Disfraz(Integer ref, String color, String marca, String talla, double valorAlquiler, String nombre) {
        super(ref, color, marca, talla, valorAlquiler);
        this.nombre = nombre;
    }

    public Disfraz() {
    }
}