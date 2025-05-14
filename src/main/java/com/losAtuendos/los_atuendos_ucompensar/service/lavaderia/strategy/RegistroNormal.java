package com.losAtuendos.los_atuendos_ucompensar.service.lavaderia.strategy;

import com.losAtuendos.los_atuendos_ucompensar.model.LavanderiaRegistro;
import com.losAtuendos.los_atuendos_ucompensar.model.Prenda;

public class RegistroNormal implements EstrategiaRegistro {
    @Override
    public LavanderiaRegistro registrarPrenda(Prenda prenda) {
        return new LavanderiaRegistro(prenda, false);
    }
}