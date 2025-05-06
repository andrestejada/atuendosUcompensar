package com.losAtuendos.los_atuendos_ucompensar.controller;

import com.losAtuendos.los_atuendos_ucompensar.dto.Lavanderia.RegistrarPrenda;
import com.losAtuendos.los_atuendos_ucompensar.model.LavanderiaRegistro;
import com.losAtuendos.los_atuendos_ucompensar.service.lavaderia.LavanderiaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lavanderia")
public class LavanderiaController {

    private final LavanderiaService lavanderiaService;

    public LavanderiaController(LavanderiaService lavanderiaService) {
        this.lavanderiaService = lavanderiaService;
    }

    @PostMapping("/registrar")
    public ResponseEntity<LavanderiaRegistro> registrarPrenda(@RequestBody  @Valid RegistrarPrenda registrarPrenda) {
        LavanderiaRegistro registro = lavanderiaService.registrarPrendaParaLavanderia(registrarPrenda.getPrendaRef(), registrarPrenda.isPrioridad());
        return ResponseEntity.status(201).body(registro);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<LavanderiaRegistro>> listarPrendasEnLavanderia() {
        List<LavanderiaRegistro> registros = lavanderiaService.obtenerPrendasEnLavanderia();
        return ResponseEntity.ok(registros);
    }
}