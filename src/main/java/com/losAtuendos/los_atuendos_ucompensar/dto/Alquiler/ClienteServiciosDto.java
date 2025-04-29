package com.losAtuendos.los_atuendos_ucompensar.dto.Alquiler;

import com.losAtuendos.los_atuendos_ucompensar.model.Cliente;
import com.losAtuendos.los_atuendos_ucompensar.model.ServicioAlquiler;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ClienteServiciosDto {
    private Cliente cliente;
    private List<ServicioAlquiler> serviciosVigentes;

    ClienteServiciosDto(){}
}
