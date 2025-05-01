package com.losAtuendos.los_atuendos_ucompensar.repository.prenda;

import com.losAtuendos.los_atuendos_ucompensar.model.Prenda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrendaRespositoryJpa extends JpaRepository<Prenda,Integer> {
    List<Prenda> findByTalla(String talla);
}
