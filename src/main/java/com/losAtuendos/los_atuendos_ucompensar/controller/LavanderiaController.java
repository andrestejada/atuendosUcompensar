package com.losAtuendos.los_atuendos_ucompensar.controller;

import com.losAtuendos.los_atuendos_ucompensar.dto.Lavanderia.RegistrarPrenda;
import com.losAtuendos.los_atuendos_ucompensar.model.LavanderiaRegistro;
import com.losAtuendos.los_atuendos_ucompensar.service.lavaderia.LavanderiaService;
import com.losAtuendos.los_atuendos_ucompensar.service.lavaderia.facade.LavanderiaFacade;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lavanderia")
public class LavanderiaController {

    private final LavanderiaService lavanderiaService;
    private final LavanderiaFacade lavanderiaFacade;
    public LavanderiaController(LavanderiaService lavanderiaService , LavanderiaFacade lavanderiaFacade) {
        this.lavanderiaService = lavanderiaService;
        this.lavanderiaFacade = lavanderiaFacade;
    }

    @PostMapping("/registrar")
    public ResponseEntity<LavanderiaRegistro> registrarPrenda(@RequestBody @Valid RegistrarPrenda registrarPrenda) {
        LavanderiaRegistro registro = lavanderiaFacade.registrarPrenda(registrarPrenda);
        return ResponseEntity.status(201).body(registro);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<LavanderiaRegistro>> listarPrendasEnLavanderia() {
        List<LavanderiaRegistro> registros = lavanderiaService.obtenerPrendasEnLavanderia();
        return ResponseEntity.ok(registros);
    }

    @PostMapping("/enviar/{cantidad}")
    public ResponseEntity<List<LavanderiaRegistro>> enviarPrendas(@PathVariable int cantidad) {
        List<LavanderiaRegistro> registrosEnviados = lavanderiaService.enviarPrendasALavanderia(cantidad);
        return ResponseEntity.ok(registrosEnviados);
    }
}