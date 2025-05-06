package com.losAtuendos.los_atuendos_ucompensar.service.lavaderia;
import com.losAtuendos.los_atuendos_ucompensar.model.LavanderiaRegistro;
import com.losAtuendos.los_atuendos_ucompensar.model.Prenda;
import com.losAtuendos.los_atuendos_ucompensar.repository.lavanderia_registro.*;
import com.losAtuendos.los_atuendos_ucompensar.service.prenda.PrendaService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

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
        LavanderiaRegistro registro = new LavanderiaRegistro(prendaEncotrada, prioridad);
        return lavanderiaRepository.guardarRegistro(registro);
    }

    public List<LavanderiaRegistro> obtenerPrendasEnLavanderia() {
        return lavanderiaRepository.obtenerRegistrosPorEstado("pendiente");
    }

    public List<LavanderiaRegistro> enviarPrendasALavanderia(int cantidad) {
        List<LavanderiaRegistro> registrosPendientes = lavanderiaRepository.obtenerRegistrosPorEstado("pendiente");

        if (registrosPendientes.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No hay prendas pendientes para enviar");
        }

        if (registrosPendientes.size() < cantidad) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No hay suficientes prendas pendientes para enviar");
        }

        registrosPendientes.sort((r1, r2) -> Boolean.compare(r2.isPrioridad(), r1.isPrioridad()));



        List<LavanderiaRegistro> registrosAEnviar = registrosPendientes.subList(0, cantidad);
        registrosAEnviar.forEach(registro -> registro.setEstado("enviado"));
        lavanderiaRepository.guardarListado(registrosAEnviar);

        return registrosAEnviar;
    }
}