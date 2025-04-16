package com.losAtuendos.los_atuendos_ucompensar.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "vestido_dama")
@Data
public class VestidoDama extends Prenda {

    private boolean pedreria;
    private String altura;
    private short cantPiezas;

    public VestidoDama(Integer ref, String color, String marca, String talla, double valorAlquiler, boolean pedreria, String altura, short cantPiezas) {
        super(ref, color, marca, talla, valorAlquiler);
        this.pedreria = pedreria;
        this.altura = altura;
        this.cantPiezas = cantPiezas;
    }
}
