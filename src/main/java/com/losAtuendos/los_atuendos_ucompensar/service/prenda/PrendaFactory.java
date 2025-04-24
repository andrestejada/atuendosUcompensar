package com.losAtuendos.los_atuendos_ucompensar.service.prenda;

import com.losAtuendos.los_atuendos_ucompensar.model.Prenda;

public abstract class PrendaFactory {
    protected abstract IPrenda crearPrenda(Prenda prenda);

    public void guardarPrenda(Prenda prenda) {
        IPrenda nuevaPrenda = this.crearPrenda(prenda);
        nuevaPrenda.crear(prenda);
    }
}
