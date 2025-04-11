package com.losAtuendos.los_atuendos_ucompensar.repository.empleado;

import com.losAtuendos.los_atuendos_ucompensar.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepositoryJpa extends JpaRepository<Empleado, String> {
}
