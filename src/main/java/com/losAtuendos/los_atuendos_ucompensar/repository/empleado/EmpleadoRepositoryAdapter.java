package com.losAtuendos.los_atuendos_ucompensar.repository.empleado;

import com.losAtuendos.los_atuendos_ucompensar.model.Empleado;
import org.springframework.stereotype.Component;

@Component
public class EmpleadoRepositoryAdapter implements EmpleadosRepository {

    private final EmpleadoRepositoryJpa empleadoRepositoryJpa;

    public EmpleadoRepositoryAdapter(EmpleadoRepositoryJpa empleadoRepositoryJpa) {
        this.empleadoRepositoryJpa = empleadoRepositoryJpa;
    }

    @Override
    public Empleado guardar(Empleado empleado) {
        return this.empleadoRepositoryJpa.save(empleado);
    }

    @Override
    public Empleado buscarPorId(Long id) {
        return this.empleadoRepositoryJpa.findById(id).orElse(null);
    }
}
