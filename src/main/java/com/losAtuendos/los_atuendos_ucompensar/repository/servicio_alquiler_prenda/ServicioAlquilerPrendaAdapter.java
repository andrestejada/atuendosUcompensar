package com.losAtuendos.los_atuendos_ucompensar.repository.servicio_alquiler_prenda;

import com.losAtuendos.los_atuendos_ucompensar.model.ServicioAlquilerPrenda;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicioAlquilerPrendaAdapter implements ServicioAlquilerPrendaRepository{

    private final ServicioAlquilerPrendaRepositoryJpa  servicioAlquilerPrendaRepositoryJpa;

    public ServicioAlquilerPrendaAdapter(ServicioAlquilerPrendaRepositoryJpa servicioAlquilerPrendaRepositoryJpa) {
        this.servicioAlquilerPrendaRepositoryJpa = servicioAlquilerPrendaRepositoryJpa;
    }

    @Override
    public List<ServicioAlquilerPrenda> guardarListado(List<ServicioAlquilerPrenda> servicioAlquilerPrendaList) {
        return this.servicioAlquilerPrendaRepositoryJpa.saveAll(servicioAlquilerPrendaList);
    }
}
