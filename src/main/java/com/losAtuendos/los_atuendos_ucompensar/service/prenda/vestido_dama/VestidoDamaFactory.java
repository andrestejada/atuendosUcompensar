package com.losAtuendos.los_atuendos_ucompensar.service.prenda.vestido_dama;

import com.losAtuendos.los_atuendos_ucompensar.model.Prenda;
import com.losAtuendos.los_atuendos_ucompensar.service.prenda.IPrenda;
import com.losAtuendos.los_atuendos_ucompensar.service.prenda.PrendaFactory;
import org.springframework.stereotype.Component;

@Component
public class VestidoDamaFactory extends PrendaFactory {

    private final VestidoDamaService vestidoDamaService;

    public VestidoDamaFactory(VestidoDamaService vestidoDamaService){
        this.vestidoDamaService = vestidoDamaService;
    }

    @Override
    protected IPrenda crearPrenda(Prenda prenda) {
        return this.vestidoDamaService;
    }
}
