package com.losAtuendos.los_atuendos_ucompensar.service.alquiler.facade;

import com.losAtuendos.los_atuendos_ucompensar.dto.Alquiler.CrearAlquilerDto;
import com.losAtuendos.los_atuendos_ucompensar.model.*;
import com.losAtuendos.los_atuendos_ucompensar.repository.servicio_alquiler.ServicioAlquilerRepository;
import com.losAtuendos.los_atuendos_ucompensar.repository.servicio_alquiler_prenda.ServicioAlquilerPrendaRepository;
import com.losAtuendos.los_atuendos_ucompensar.service.ClienteService;
import com.losAtuendos.los_atuendos_ucompensar.service.EmpleadoService;
import com.losAtuendos.los_atuendos_ucompensar.service.prenda.PrendaService;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class AlquilerFacade {

    private final ServicioAlquilerRepository servicioAlquilerRepository;
    private final ServicioAlquilerPrendaRepository servicioAlquilerPrendaRepository;
    private final EmpleadoService empleadoService;
    private final ClienteService clienteService;
    private final PrendaService prendaService;

    public AlquilerFacade(ServicioAlquilerRepository servicioAlquilerRepository,
                          ServicioAlquilerPrendaRepository servicioAlquilerPrendaRepository,
                          EmpleadoService empleadoService,
                          ClienteService clienteService,
                          PrendaService prendaService) {
        this.servicioAlquilerRepository = servicioAlquilerRepository;
        this.servicioAlquilerPrendaRepository = servicioAlquilerPrendaRepository;
        this.empleadoService = empleadoService;
        this.clienteService = clienteService;
        this.prendaService = prendaService;
    }

    public Integer guardarAlquiler(CrearAlquilerDto dto) throws BadRequestException {
        Empleado empleado = empleadoService.buscarEmpleadoPorId(dto.getIdEmpleado());
        if (empleado == null) {
            throw new BadRequestException("El empleado no existe");
        }

        Cliente cliente = clienteService.obtenerCliente(dto.getIdCliente());
        if (cliente == null) {
            throw new BadRequestException("El cliente no existe");
        }

        List<Prenda> prendas = prendaService.obtenerPrendaPorIds(dto.getIdPrendas());
        if (prendas.isEmpty() || prendas.size() != dto.getIdPrendas().size()) {
            throw new BadRequestException("No se encontraron todas las prendas con los ids proporcionados");
        }

        ServicioAlquiler servicioAlquiler = new ServicioAlquiler(
                null,
                Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()),
                dto.getFechaAlquiler(),
                new ArrayList<>()
        );
        ServicioAlquiler alquilerCreado = servicioAlquilerRepository.guardar(servicioAlquiler);

        List<ServicioAlquilerPrenda> alquilerPrendas = new ArrayList<>();
        for (Prenda prenda : prendas) {
            ServicioAlquilerPrenda alquilerPrenda = new ServicioAlquilerPrenda(
                                null, alquilerCreado, prenda, cliente, empleado
                        );
            alquilerPrendas.add(alquilerPrenda);
        }

        servicioAlquilerPrendaRepository.guardarListado(alquilerPrendas);
        return alquilerCreado.getNumero();
    }
}