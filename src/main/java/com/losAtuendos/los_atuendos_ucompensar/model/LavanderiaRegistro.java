package com.losAtuendos.los_atuendos_ucompensar.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.losAtuendos.los_atuendos_ucompensar.service.lavaderia.state.LavanderiaEstado;
import com.losAtuendos.los_atuendos_ucompensar.service.lavaderia.state.PendienteEstado;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "lavanderia_registro")
public class LavanderiaRegistro {

    @Transient
    @JsonIgnore
    private LavanderiaEstado estadoActual = new PendienteEstado();

    public void enviar() { estadoActual.enviar(this); }
    public void pendiente() { estadoActual.pendiente(this); }
    public void setEstadoActual(LavanderiaEstado estado) { this.estadoActual = estado; }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "prenda_id", nullable = false)
    private Prenda prenda;

    @Column(nullable = false)
    private boolean prioridad;

    @Column(nullable = false)
    private String estado = "pendiente";

    public LavanderiaRegistro(Prenda prenda, boolean prioridad) {
        this.prenda = prenda;
        this.prioridad = prioridad;
    }
}