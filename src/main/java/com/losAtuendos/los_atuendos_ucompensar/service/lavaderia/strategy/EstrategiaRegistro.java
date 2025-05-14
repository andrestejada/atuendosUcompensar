package com.losAtuendos.los_atuendos_ucompensar.service.lavaderia.strategy;

import com.losAtuendos.los_atuendos_ucompensar.model.LavanderiaRegistro;
import com.losAtuendos.los_atuendos_ucompensar.model.Prenda;

public interface EstrategiaRegistro {
    LavanderiaRegistro registrarPrenda(Prenda prenda);
}