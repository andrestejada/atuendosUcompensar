package com.losAtuendos.los_atuendos_ucompensar.service.prenda.traje_caballero;

import com.losAtuendos.los_atuendos_ucompensar.model.Prenda;
import com.losAtuendos.los_atuendos_ucompensar.model.TrajeCaballero;
import com.losAtuendos.los_atuendos_ucompensar.repository.prenda.traje_caballero.TrajeCaballeroRepository;
import com.losAtuendos.los_atuendos_ucompensar.service.prenda.IPrenda;
import org.springframework.stereotype.Service;

@Service
public class TrajeCaballeroService implements IPrenda {

    private TrajeCaballeroRepository trajeCaballeroRepository;

    public TrajeCaballeroService(TrajeCaballeroRepository trajeCaballeroRepository) {
        this.trajeCaballeroRepository = trajeCaballeroRepository;
    }

    @Override
    public void crear(Prenda prenda) {
        if (!(prenda instanceof TrajeCaballero)) {
            throw new IllegalArgumentException("El objeto no es una instancia de TrajeCaballero");
        }
        TrajeCaballero trajeCaballero = (TrajeCaballero) prenda;
        this.trajeCaballeroRepository.crear(trajeCaballero);
    }
}
