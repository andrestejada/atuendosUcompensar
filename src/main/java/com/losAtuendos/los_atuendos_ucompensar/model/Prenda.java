package com.losAtuendos.los_atuendos_ucompensar.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_prenda", discriminatorType = DiscriminatorType.STRING)
@Table(name = "prenda")
public abstract class Prenda {

    @Id
    @Column(unique = true, nullable = false)
    private Integer ref;
    private String color;
    private String marca;
    private String talla;
    private double valorAlquiler;

    @OneToMany(mappedBy = "prenda", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private List<ServicioAlquilerPrenda> servicioAlquilerPrendas;

    public Prenda(Integer ref, String color, String marca, String talla, double valorAlquiler) {
        this.ref = ref;
        this.color = color;
        this.marca = marca;
        this.talla = talla;
        this.valorAlquiler = valorAlquiler;
    }
}