package com.losAtuendos.los_atuendos_ucompensar.service.lavaderia.observer;

import com.losAtuendos.los_atuendos_ucompensar.model.LavanderiaRegistro;
import java.util.List;

public interface LavanderiaObserver {
    void onPrendasEnviadas(List<LavanderiaRegistro> registros);
}