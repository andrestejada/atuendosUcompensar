package com.losAtuendos.los_atuendos_ucompensar.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@Table(name = "cliente")
public class Cliente extends Persona {
    private String email;

    public Cliente( Long id, String nombre, String direccion, String telefono,String email){
        super(id, nombre, direccion, telefono);
        this.email = email;
    }
}
