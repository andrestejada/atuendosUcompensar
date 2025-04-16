package com.losAtuendos.los_atuendos_ucompensar.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "traje_caballero")
@Data
public class TrajeCaballero extends Prenda {
    private String tipo;
    private String aderezo;

    public TrajeCaballero(Integer ref, String color, String marca, String talla, double valorAlquiler, String tipo, String aderezo) {
        super(ref, color, marca, talla, valorAlquiler);
        this.tipo = tipo;
        this.aderezo = aderezo;
    }
}
