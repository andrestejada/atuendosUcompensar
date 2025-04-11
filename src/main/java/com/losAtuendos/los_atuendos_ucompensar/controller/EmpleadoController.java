package com.losAtuendos.los_atuendos_ucompensar.controller;

import com.losAtuendos.los_atuendos_ucompensar.dto.empleado.CrearEmpleadoDto;
import com.losAtuendos.los_atuendos_ucompensar.model.Empleado;
import com.losAtuendos.los_atuendos_ucompensar.service.EmpleadoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/empleado")
public class EmpleadoController {

    private final EmpleadoService empleadoService;
    EmpleadoController(EmpleadoService empleadoService){
        this.empleadoService = empleadoService;
    }

    @PostMapping
    Empleado crearEmpleado(@RequestBody @Valid CrearEmpleadoDto dto){
        return empleadoService.crearEmpleado(dto);

    }
}
