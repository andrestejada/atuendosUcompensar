package com.losAtuendos.los_atuendos_ucompensar.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("TRAJE_CABALLERO")
@Data
public class TrajeCaballero extends Prenda {
    private String tipo;
    private String aderezo;

    public TrajeCaballero(Integer ref, String color, String marca, String talla, double valorAlquiler, String tipo, String aderezo) {
        super(ref, color, marca, talla, valorAlquiler);
        this.tipo = tipo;
        this.aderezo = aderezo;
    }

    public TrajeCaballero() {
    }
}