package com.losAtuendos.los_atuendos_ucompensar.service.alquiler;

import com.losAtuendos.los_atuendos_ucompensar.dto.Alquiler.AlquilerDetalleDto;
import com.losAtuendos.los_atuendos_ucompensar.dto.Alquiler.ClienteServiciosDto;
import com.losAtuendos.los_atuendos_ucompensar.dto.Alquiler.CrearAlquilerDto;
import com.losAtuendos.los_atuendos_ucompensar.model.Cliente;
import com.losAtuendos.los_atuendos_ucompensar.model.ServicioAlquiler;
import com.losAtuendos.los_atuendos_ucompensar.model.ServicioAlquilerPrenda;
import com.losAtuendos.los_atuendos_ucompensar.repository.servicio_alquiler_prenda.ServicioAlquilerPrendaRepository;
import com.losAtuendos.los_atuendos_ucompensar.service.ClienteService;
import com.losAtuendos.los_atuendos_ucompensar.service.alquiler.facade.AlquilerFacade;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AlquilerService {


    private final ClienteService clienteService;
    private final ServicioAlquilerPrendaRepository servicioAlquilerPrendaRepository;
    private final AlquilerFacade alquilerFacade;

    public AlquilerService(
            ClienteService clienteService, ServicioAlquilerPrendaRepository servicioAlquilerPrendaRepository, AlquilerFacade alquilerFacade) {


        this.clienteService = clienteService;
        this.servicioAlquilerPrendaRepository = servicioAlquilerPrendaRepository;
        this.alquilerFacade = alquilerFacade;
    }

    public Integer guardarAlquiler(CrearAlquilerDto dto) throws BadRequestException {
        return alquilerFacade.guardarAlquiler(dto);
    }


    public AlquilerDetalleDto obtenerAlquiler(Integer id) {
        List<ServicioAlquilerPrenda> res = this.servicioAlquilerPrendaRepository.obtenerPorServicioAlquilerId(id);

        return new AlquilerDetalleDto(res.get(0).getCliente(), res.get(0).getEmpleado(), res.stream().map(ServicioAlquilerPrenda::getPrenda).toList());
    }

    public ClienteServiciosDto obtenerClienteAlquileres(Long id) throws BadRequestException {
        Cliente cliente = this.clienteService.obtenerCliente(id);
        if (cliente == null) {
            throw new BadRequestException("El cliente no existe");
        }

        List<ServicioAlquiler> serviciosVigente = this.servicioAlquilerPrendaRepository.findServiciosVigentesByClienteId(id);

        return new ClienteServiciosDto(cliente, serviciosVigente);
    }

    public List<ServicioAlquilerPrenda> obtenerServiciosPorFecha(LocalDate fechaAlquiler) {
        return this.servicioAlquilerPrendaRepository.findByFechaAlquiler(fechaAlquiler);
    }
}
