package com.losAtuendos.los_atuendos_ucompensar.service.lavaderia.observer;

import com.losAtuendos.los_atuendos_ucompensar.model.LavanderiaRegistro;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LavanderiaLoggerObserver implements LavanderiaObserver {
    @Override
    public void onPrendasEnviadas(List<LavanderiaRegistro> registros) {
        System.out.println("Prendas enviadas a lavandería: " + registros.size());
    }
}