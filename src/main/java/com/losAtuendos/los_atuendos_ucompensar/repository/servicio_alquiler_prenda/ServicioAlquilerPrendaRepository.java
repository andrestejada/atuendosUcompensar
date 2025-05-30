package com.losAtuendos.los_atuendos_ucompensar.repository.servicio_alquiler_prenda;

import com.losAtuendos.los_atuendos_ucompensar.model.ServicioAlquiler;
import com.losAtuendos.los_atuendos_ucompensar.model.ServicioAlquilerPrenda;

import java.time.LocalDate;
import java.util.List;

public interface ServicioAlquilerPrendaRepository {
    List<ServicioAlquilerPrenda> guardarListado(List<ServicioAlquilerPrenda> servicioAlquilerPrendaList);
    List<ServicioAlquilerPrenda> obtenerPorServicioAlquilerId(Integer servicioAlquilerId);
    List<ServicioAlquiler> findServiciosVigentesByClienteId(Long clienteId);
    List<ServicioAlquilerPrenda> findByFechaAlquiler(LocalDate fechaAlquiler);
}
