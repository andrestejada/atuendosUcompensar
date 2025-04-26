package com.losAtuendos.los_atuendos_ucompensar.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@Table(name = "servicio_alquiler")
public class    ServicioAlquiler {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer numero;

    private Date fechaSolicitud;

    private Date fechaAlquiler;

    @OneToMany(mappedBy = "servicioAlquiler", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ServicioAlquilerPrenda> servicioAlquilerPrendas;


}