package com.losAtuendos.los_atuendos_ucompensar.dto.Alquiler;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Min;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class CrearAlquilerDto {


    @NotNull
    private Date fechaAlquiler;

    @NotNull
    @Size(min = 1, message = "Debe haber al menos un ID de prenda.")
    private List<Integer> idPrendas;

    @NotNull
    @Min(value = 1, message = "El ID del cliente debe ser mayor a 0.")
    private Long idCliente;

    @NotNull
    @Min(value = 1, message = "El ID del empleado debe ser mayor a 0.")
    private Long idEmpleado;

}