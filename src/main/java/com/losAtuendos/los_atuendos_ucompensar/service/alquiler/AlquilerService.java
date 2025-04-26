package com.losAtuendos.los_atuendos_ucompensar.service.alquiler;

import com.losAtuendos.los_atuendos_ucompensar.dto.Alquiler.CrearAlquilerDto;
import com.losAtuendos.los_atuendos_ucompensar.model.*;
import com.losAtuendos.los_atuendos_ucompensar.repository.servicio_alquiler.ServicioAlquilerRepository;
import com.losAtuendos.los_atuendos_ucompensar.repository.servicio_alquiler_prenda.ServicioAlquilerPrendaRepository;
import com.losAtuendos.los_atuendos_ucompensar.service.ClienteService;
import com.losAtuendos.los_atuendos_ucompensar.service.EmpleadoService;
import com.losAtuendos.los_atuendos_ucompensar.service.prenda.PrendaService;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AlquilerService {

    private final ServicioAlquilerRepository servicioAlquilerRepository;
    private final EmpleadoService empleadoService;
    private final ClienteService clienteService;
    private final PrendaService prendaService;
    private final ServicioAlquilerPrendaRepository servicioAlquilerPrendaRepository;

    public AlquilerService(ServicioAlquilerRepository servicioAlquilerRepository, EmpleadoService empleadoService,
                           ClienteService clienteService ,PrendaService prendaService,ServicioAlquilerPrendaRepository servicioAlquilerPrendaRepository) {

        this.servicioAlquilerRepository = servicioAlquilerRepository;
        this.empleadoService = empleadoService;
        this.clienteService = clienteService;
        this.prendaService = prendaService;
        this.servicioAlquilerPrendaRepository = servicioAlquilerPrendaRepository;
    }

    public Integer guardarAlquiler(CrearAlquilerDto dto) throws BadRequestException {
        Empleado empleadoEncontrado = this.empleadoService.buscarEmpleadoPorId(dto.getIdEmpleado());
        if (empleadoEncontrado == null) {
            throw new BadRequestException("El empleado no existe");
        }
        Cliente clienteEncontrado = this.clienteService.obtenerCliente(dto.getIdCliente());
        if (clienteEncontrado == null) {
            throw new BadRequestException("El cliente no existe");
        }

        List<Prenda> prendas = this.prendaService.obtenerPrendaPorIds(dto.getIdPrendas());
        if(prendas.isEmpty()){
            throw new BadRequestException("No se encontraron prendas con los ids proporcionados");

        }
        if (prendas.size() != dto.getIdPrendas().size()) {
            throw new BadRequestException("No se encontraron todas las prendas con los ids proporcionados");
        }

        ServicioAlquiler newServicioAlquiler = new ServicioAlquiler(
                null,
                Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()),
                dto.getFechaAlquiler(),
                new ArrayList<>()
        );
        ServicioAlquiler alquilerCreado = this.servicioAlquilerRepository.guardar(newServicioAlquiler);

        List<ServicioAlquilerPrenda> listadoAlquilerPrendas = new ArrayList<>();
        for (Prenda prenda : prendas){
            listadoAlquilerPrendas.add(new ServicioAlquilerPrenda(
                    null,alquilerCreado,prenda,clienteEncontrado,empleadoEncontrado
            ));
        }

        this.servicioAlquilerPrendaRepository.guardarListado(listadoAlquilerPrendas);
        return alquilerCreado.getNumero();
    }
}
