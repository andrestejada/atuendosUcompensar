package com.losAtuendos.los_atuendos_ucompensar.repository.prenda.traje_caballero;

import com.losAtuendos.los_atuendos_ucompensar.model.TrajeCaballero;

public class TrajeCaballeroAdapter implements TrajeCaballeroRepository{

    private final TrajeCaballeroRepositoryJpa trajeCaballeroRepositoryJpa;

    public TrajeCaballeroAdapter(TrajeCaballeroRepositoryJpa trajeCaballeroRepositoryJpa) {
        this.trajeCaballeroRepositoryJpa = trajeCaballeroRepositoryJpa;
    }

    @Override
    public void crear(TrajeCaballero trajeCaballero) {
        this.trajeCaballeroRepositoryJpa.save(trajeCaballero);
    }
}
