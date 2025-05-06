package com.losAtuendos.los_atuendos_ucompensar.repository.lavanderia_registro;

import com.losAtuendos.los_atuendos_ucompensar.model.LavanderiaRegistro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LavanderiaRepositoryJpa extends JpaRepository<LavanderiaRegistro,Long> {
    List<LavanderiaRegistro> findByEstado(String estado);
}
