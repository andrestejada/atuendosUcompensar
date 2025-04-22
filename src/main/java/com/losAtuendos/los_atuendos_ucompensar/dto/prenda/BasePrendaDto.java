package com.losAtuendos.los_atuendos_ucompensar.dto.prenda;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public abstract class BasePrendaDto {
    @NotNull(message = "referencia es requerida")
    @Positive
    private Integer ref;

    @NotBlank
    private String color;

    @NotBlank
    private String marca;

    @NotBlank
    private String talla;

    @NotNull
    @Positive
    private double valorAlquiler;
}
