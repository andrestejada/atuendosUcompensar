package com.losAtuendos.los_atuendos_ucompensar.repository.prenda;

import com.losAtuendos.los_atuendos_ucompensar.model.Prenda;

import java.util.List;

public interface PrendaRepository {
    List<Prenda> obtenerPrendaPorIds(List<Integer> ids);
    List<Prenda> findByTalla(String talla);
}
