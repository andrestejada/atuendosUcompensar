package com.losAtuendos.los_atuendos_ucompensar.repository.servicio_alquiler_prenda;

import com.losAtuendos.los_atuendos_ucompensar.model.ServicioAlquiler;
import com.losAtuendos.los_atuendos_ucompensar.model.ServicioAlquilerPrenda;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
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

    @Override
    public List<ServicioAlquilerPrenda> obtenerPorServicioAlquilerId(Integer servicioAlquilerId) {
        return this.servicioAlquilerPrendaRepositoryJpa.findByServicioAlquilerId(servicioAlquilerId);
    }

    @Override
    public List<ServicioAlquiler> findServiciosVigentesByClienteId(Long clienteId) {
        return this.servicioAlquilerPrendaRepositoryJpa.obtenerServiciosVigentesByClienteId(clienteId);
    }

    @Override
    public List<ServicioAlquilerPrenda> findByFechaAlquiler(LocalDate fechaAlquiler) {
        return this.servicioAlquilerPrendaRepositoryJpa.findByFechaAlquiler(fechaAlquiler);
    }


}
