package com.losAtuendos.los_atuendos_ucompensar.controller;


import com.losAtuendos.los_atuendos_ucompensar.dto.Alquiler.AlquilerReponseDto;
import com.losAtuendos.los_atuendos_ucompensar.dto.Alquiler.CrearAlquilerDto;
import com.losAtuendos.los_atuendos_ucompensar.dto.Alquiler.AlquilerDetalleDto;
import com.losAtuendos.los_atuendos_ucompensar.model.ServicioAlquilerPrenda;
import com.losAtuendos.los_atuendos_ucompensar.service.alquiler.AlquilerService;
import jakarta.validation.Valid;
import org.apache.coyote.BadRequestException;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/alquiler")
public class AlquilerControler {

    private final AlquilerService  alquilerService;

    public AlquilerControler(AlquilerService alquilerService) {
        this.alquilerService = alquilerService;
    }

    @PostMapping
    ResponseEntity<AlquilerReponseDto> crearAlquiler(@RequestBody @Valid CrearAlquilerDto dto) throws BadRequestException {
        Integer numero = this.alquilerService.guardarAlquiler(dto);
        return new ResponseEntity<>(new AlquilerReponseDto("Alquiler creado con exito", numero), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    AlquilerDetalleDto obtenerAlquiler(@PathVariable Integer id) {
        return this.alquilerService.obtenerAlquiler(id);
    }

    @GetMapping("/fecha/{fechaAlquiler}")
    public List<ServicioAlquilerPrenda> obtenerServiciosPorFecha(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaAlquiler) {
        return alquilerService.obtenerServiciosPorFecha(fechaAlquiler);
    }
}
