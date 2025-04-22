package com.losAtuendos.los_atuendos_ucompensar.service.Prenda;

import com.losAtuendos.los_atuendos_ucompensar.model.Prenda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DisfrazFactory extends PrendaFactory {

    private final DisfrazService disfrazService;

    @Autowired
    public DisfrazFactory(DisfrazService disfrazService) {
        this.disfrazService = disfrazService;
    }

    @Override
    protected IPrenda crearPrenda(Prenda prenda) {
        return disfrazService;
    }
}