package com.losAtuendos.los_atuendos_ucompensar.repository.prenda.vestido_dama;

import com.losAtuendos.los_atuendos_ucompensar.model.VestidoDama;
import org.springframework.stereotype.Component;

@Component
public class VestidoDamaAdapter implements VestidoDamaRepository{

    private final VestidoDamaRepositoryJpa vestidoDamaRepositoryJpa;

    public VestidoDamaAdapter(VestidoDamaRepositoryJpa vestidoDamaRepositoryJpa){
        this.vestidoDamaRepositoryJpa = vestidoDamaRepositoryJpa;
    }

    @Override
    public void crear(VestidoDama vestidoDama) {
        this.vestidoDamaRepositoryJpa.save(vestidoDama);
    }
}
