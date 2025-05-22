package com.losAtuendos.los_atuendos_ucompensar.service.lavaderia.state;

import com.losAtuendos.los_atuendos_ucompensar.model.LavanderiaRegistro;

public interface LavanderiaEstado {
    void enviar(LavanderiaRegistro registro);
    void pendiente(LavanderiaRegistro registro);
    String getNombre();
}