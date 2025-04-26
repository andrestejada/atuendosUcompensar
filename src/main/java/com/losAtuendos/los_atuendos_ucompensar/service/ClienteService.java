package com.losAtuendos.los_atuendos_ucompensar.service;

import com.losAtuendos.los_atuendos_ucompensar.dto.cliente.CrearClienteDto;
import com.losAtuendos.los_atuendos_ucompensar.model.Cliente;
import com.losAtuendos.los_atuendos_ucompensar.repository.cliente.ClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente crearCliente(CrearClienteDto dto) {
        Cliente newCliente = new Cliente(
                null,
                dto.getNombre(),
                dto.getDireccion(),
                dto.getTelefono(),
                dto.getEmail());


        return this.clienteRepository.guardar(newCliente);
    }

    public Cliente obtenerCliente(Long id) {
        return this.clienteRepository.buscarPorId(id);
    }
}
