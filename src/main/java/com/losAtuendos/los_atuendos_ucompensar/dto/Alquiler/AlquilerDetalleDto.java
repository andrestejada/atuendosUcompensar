package com.losAtuendos.los_atuendos_ucompensar.dto.Alquiler;

import com.losAtuendos.los_atuendos_ucompensar.model.Cliente;
import com.losAtuendos.los_atuendos_ucompensar.model.Empleado;
import com.losAtuendos.los_atuendos_ucompensar.model.Prenda;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AlquilerDetalleDto {
    private Cliente cliente;
    private Empleado empleado;
    private List<Prenda> prendas;
}
