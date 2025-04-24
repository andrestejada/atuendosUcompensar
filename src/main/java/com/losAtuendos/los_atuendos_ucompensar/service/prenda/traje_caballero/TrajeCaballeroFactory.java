package com.losAtuendos.los_atuendos_ucompensar.service.prenda.traje_caballero;

import com.losAtuendos.los_atuendos_ucompensar.model.Prenda;
import com.losAtuendos.los_atuendos_ucompensar.service.prenda.IPrenda;
import com.losAtuendos.los_atuendos_ucompensar.service.prenda.PrendaFactory;
import org.springframework.stereotype.Component;

@Component
public class TrajeCaballeroFactory extends PrendaFactory {

    private TrajeCaballeroService trajeCaballeroService;

    TrajeCaballeroFactory(TrajeCaballeroService trajeCaballeroService) {
        this.trajeCaballeroService = trajeCaballeroService;
    }

    @Override
    protected IPrenda crearPrenda(Prenda prenda) {
        return trajeCaballeroService;
    }
}
