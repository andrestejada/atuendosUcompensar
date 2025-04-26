package com.losAtuendos.los_atuendos_ucompensar.repository.servicio_alquiler_prenda;

import com.losAtuendos.los_atuendos_ucompensar.model.ServicioAlquilerPrenda;

import java.util.List;

public interface ServicioAlquilerPrendaRepository {
    List<ServicioAlquilerPrenda> guardarListado(List<ServicioAlquilerPrenda> servicioAlquilerPrendaList);
}
