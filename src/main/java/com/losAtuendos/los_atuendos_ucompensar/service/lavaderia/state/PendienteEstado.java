package com.losAtuendos.los_atuendos_ucompensar.service.lavaderia.state;

import com.losAtuendos.los_atuendos_ucompensar.model.LavanderiaRegistro;

public class PendienteEstado implements LavanderiaEstado {
    @Override
    public void enviar(LavanderiaRegistro registro) {
        registro.setEstadoActual(new EnviadoEstado());
        registro.setEstado("enviado");
    }

    @Override
    public void pendiente(LavanderiaRegistro registro) {
        // Already pending, do nothing or throw exception if needed
        throw new IllegalStateException("Ya está pendiente.");
    }

    @Override
    public String getNombre() { return "pendiente"; }
}