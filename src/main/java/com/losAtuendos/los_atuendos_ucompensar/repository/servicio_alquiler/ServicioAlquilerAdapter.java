package com.losAtuendos.los_atuendos_ucompensar.repository.servicio_alquiler;

import com.losAtuendos.los_atuendos_ucompensar.model.ServicioAlquiler;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicioAlquilerAdapter implements ServicioAlquilerRepository{

    private final ServicioAlquilerRepositoryJpa servicioAlquilerRepositoryJpa;

    public ServicioAlquilerAdapter(ServicioAlquilerRepositoryJpa servicioAlquilerRepositoryJpa) {
        this.servicioAlquilerRepositoryJpa = servicioAlquilerRepositoryJpa;
    }


    @Override
    public ServicioAlquiler guardar(ServicioAlquiler servicioAlquiler) {
        return this.servicioAlquilerRepositoryJpa.save(servicioAlquiler);
    }

}
