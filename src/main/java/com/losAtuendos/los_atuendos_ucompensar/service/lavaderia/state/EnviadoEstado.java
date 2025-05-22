package com.losAtuendos.los_atuendos_ucompensar.service.lavaderia.state;

import com.losAtuendos.los_atuendos_ucompensar.model.LavanderiaRegistro;

public class EnviadoEstado implements LavanderiaEstado {
    public void enviar(LavanderiaRegistro registro) {
        throw new IllegalStateException("Ya está enviada.");
    }

    @Override
    public void pendiente(LavanderiaRegistro registro) {
        registro.setEstadoActual(new PendienteEstado());
        registro.setEstado("pendiente");
    }

    public String getNombre() { return "enviado"; }
}