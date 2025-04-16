package com.losAtuendos.los_atuendos_ucompensar.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "empleado")
public class Empleado extends Persona {
    private String cargo;

    public Empleado(Long id, String nombre, String direccion, String telefono, String cargo) {
        super(id, nombre, direccion, telefono);
        this.cargo = cargo;
    }
}
