package com.losAtuendos.los_atuendos_ucompensar.service.lavaderia.facade;

import com.losAtuendos.los_atuendos_ucompensar.dto.Lavanderia.RegistrarPrenda;
import com.losAtuendos.los_atuendos_ucompensar.model.LavanderiaRegistro;
import com.losAtuendos.los_atuendos_ucompensar.model.Prenda;
import com.losAtuendos.los_atuendos_ucompensar.service.lavaderia.LavanderiaService;
import com.losAtuendos.los_atuendos_ucompensar.service.prenda.PrendaService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class LavanderiaFacade {

    private final LavanderiaService lavanderiaService;
    private final PrendaService prendaService;

    public LavanderiaFacade(LavanderiaService lavanderiaService, PrendaService prendaService) {
        this.lavanderiaService = lavanderiaService;
        this.prendaService = prendaService;
    }

    public LavanderiaRegistro registrarPrenda(RegistrarPrenda registrarPrenda) {
        Prenda prenda = prendaService.obtenerPrendaPorId(registrarPrenda.getPrendaRef());
        if (prenda == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Prenda no encontrada");
        }
        return lavanderiaService.registrarPrendaParaLavanderia(registrarPrenda.getPrendaRef(), registrarPrenda.isPrioridad());
    }
}