package com.losAtuendos.los_atuendos_ucompensar.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@Table(name = "servicio_alquiler")
public class    ServicioAlquiler {
    ServicioAlquiler(){}

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer numero;

    private Date fechaSolicitud;

    private LocalDate fechaAlquiler;

    @OneToMany(mappedBy = "servicioAlquiler", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<ServicioAlquilerPrenda> servicioAlquilerPrendas;


}