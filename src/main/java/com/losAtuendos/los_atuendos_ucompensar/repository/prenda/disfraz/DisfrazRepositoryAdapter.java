package com.losAtuendos.los_atuendos_ucompensar.repository.prenda.disfraz;

import com.losAtuendos.los_atuendos_ucompensar.model.Disfraz;
import org.springframework.stereotype.Component;

@Component
public class DisfrazRepositoryAdapter implements  DisfrazRepository{

    private final DisfrazRepositoryJpa disfrazRepositoryJpa;

    public DisfrazRepositoryAdapter(DisfrazRepositoryJpa disfrazRepositoryJpa) {
        this.disfrazRepositoryJpa = disfrazRepositoryJpa;
    }

    @Override
    public void guardar(Disfraz disfraz) {
        System.out.println("Guardando disfraz: " + disfraz);
        this.disfrazRepositoryJpa.save(disfraz);
    }
}
