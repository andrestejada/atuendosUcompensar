package com.losAtuendos.los_atuendos_ucompensar.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "disfraz")
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
