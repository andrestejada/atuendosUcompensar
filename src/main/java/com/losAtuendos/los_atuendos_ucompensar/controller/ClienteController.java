package com.losAtuendos.los_atuendos_ucompensar.controller;


import com.losAtuendos.los_atuendos_ucompensar.dto.cliente.CrearClienteDto;
import com.losAtuendos.los_atuendos_ucompensar.model.Cliente;
import com.losAtuendos.los_atuendos_ucompensar.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/cliente")
@RestController
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public Cliente crearCliente(@RequestBody @Valid CrearClienteDto dto){
        return this.clienteService.crearCliente(dto);
    }

    @GetMapping
    public Cliente obtenerCliente(@RequestParam String id){
        return this.clienteService.obtenerCliente(id);
    }
}
