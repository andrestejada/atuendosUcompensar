package com.losAtuendos.los_atuendos_ucompensar.service.lavaderia.observer;

import com.losAtuendos.los_atuendos_ucompensar.model.LavanderiaRegistro;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LavanderiaNotificationObserver implements LavanderiaObserver {
    @Override
    public void onPrendasEnviadas(List<LavanderiaRegistro> registros) {
        System.out.println("Notificación: Se han enviado " + registros.size() + " prendas a la lavandería.");
    }
}