package com.losAtuendos.los_atuendos_ucompensar.service;

import com.losAtuendos.los_atuendos_ucompensar.model.LavanderiaRegistro;
import com.losAtuendos.los_atuendos_ucompensar.model.Prenda;
import com.losAtuendos.los_atuendos_ucompensar.repository.lavanderia_registro.*;
import com.losAtuendos.los_atuendos_ucompensar.service.prenda.PrendaService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.server.ResponseStatusException;

@Service
public class LavanderiaService {

    private final LavanderiaRepository lavanderiaRepository;
    private final PrendaService prendaService;

    public LavanderiaService(LavanderiaRepository lavanderiaRepository, PrendaService prendaService) {
        this.lavanderiaRepository = lavanderiaRepository;
        this.prendaService = prendaService;
    }

    public LavanderiaRegistro registrarPrendaParaLavanderia(Integer prendaRef, boolean prioridad) {
        Prenda prendaEncotrada = this.prendaService.obtenerPrendaPorId(prendaRef);
        if (prendaEncotrada == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Prenda no encontrada");
        }
        LavanderiaRegistro registro = new LavanderiaRegistro(prendaRef, prioridad);
        return lavanderiaRepository.guardarRegistro(registro);
    }
}