package com.losAtuendos.los_atuendos_ucompensar.dto.Lavanderia;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegistrarPrenda {

    @NotNull
    private Integer prendaRef;

    @NotNull
    private boolean prioridad;
}
