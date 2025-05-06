package com.losAtuendos.los_atuendos_ucompensar.repository.lavanderia_registro;

import com.losAtuendos.los_atuendos_ucompensar.model.LavanderiaRegistro;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LavanderiaRepositoryAdapter implements LavanderiaRepository {

    private final LavanderiaRepositoryJpa lavanderiaRepositoryJpa;

    public LavanderiaRepositoryAdapter(LavanderiaRepositoryJpa lavanderiaRepositoryJpa) {
        this.lavanderiaRepositoryJpa = lavanderiaRepositoryJpa;
    }

    @Override
    public LavanderiaRegistro guardarRegistro(LavanderiaRegistro lavanderiaRegistro) {
        return this.lavanderiaRepositoryJpa.save(lavanderiaRegistro);
    }

    @Override
    public List<LavanderiaRegistro> obtenerTodosLosRegistros() {
        return this.lavanderiaRepositoryJpa.findAll();
    }
}
