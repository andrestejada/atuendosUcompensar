package com.losAtuendos.los_atuendos_ucompensar.repository.empleado;

import com.losAtuendos.los_atuendos_ucompensar.model.Empleado;


public interface EmpleadosRepository {
    Empleado guardar(Empleado empleado);
    Empleado buscarPorId(Long id);
}

