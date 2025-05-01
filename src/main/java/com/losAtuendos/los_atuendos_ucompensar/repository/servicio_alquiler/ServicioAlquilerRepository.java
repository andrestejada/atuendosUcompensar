package com.losAtuendos.los_atuendos_ucompensar.repository.servicio_alquiler;

import com.losAtuendos.los_atuendos_ucompensar.model.ServicioAlquiler;

import java.util.List;

public interface ServicioAlquilerRepository {
    ServicioAlquiler guardar(ServicioAlquiler servicioAlquiler);
    ServicioAlquiler obtenerPorId(Integer id);

}
