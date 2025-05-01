package com.losAtuendos.los_atuendos_ucompensar.service;

import com.losAtuendos.los_atuendos_ucompensar.dto.Alquiler.ClienteServiciosDto;
import com.losAtuendos.los_atuendos_ucompensar.dto.cliente.CrearClienteDto;
import com.losAtuendos.los_atuendos_ucompensar.model.Cliente;
import com.losAtuendos.los_atuendos_ucompensar.model.ServicioAlquiler;
import com.losAtuendos.los_atuendos_ucompensar.repository.cliente.ClienteRepository;
import com.losAtuendos.los_atuendos_ucompensar.repository.servicio_alquiler_prenda.ServicioAlquilerPrendaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final ServicioAlquilerPrendaRepository servicioAlquilerPrendaRepository;

    public ClienteService(ClienteRepository clienteRepository ,
                          ServicioAlquilerPrendaRepository servicioAlquilerPrendaRepository) {
        this.clienteRepository = clienteRepository;
        this.servicioAlquilerPrendaRepository = servicioAlquilerPrendaRepository;
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
    public ClienteServiciosDto obtenerClienteAlquileres(Long id){
        Cliente cliente = this.clienteRepository.buscarPorId(id);
        if(cliente == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "cliente no encontrado");
        }
        List<ServicioAlquiler> serAlquiler = this.servicioAlquilerPrendaRepository.findServiciosVigentesByClienteId(id);

        return new ClienteServiciosDto(cliente,serAlquiler);
    }
}
