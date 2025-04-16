package com.losAtuendos.los_atuendos_ucompensar.controller;


import com.losAtuendos.los_atuendos_ucompensar.dto.cliente.CrearClienteDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/cliente")
@RestController
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    void crearCliente(@RequestBody @Valid CrearClienteDto dto){
        this.clienteService.crearCliente(dto);
    }
}
