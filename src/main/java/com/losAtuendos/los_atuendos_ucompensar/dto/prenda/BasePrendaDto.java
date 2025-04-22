package com.losAtuendos.los_atuendos_ucompensar.dto.prenda;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public abstract class BasePrendaDto {
    @NotBlank(message = "referencia es requerida")
    private Integer ref;

    @NotBlank
    private String color;

    @NotBlank
    private String marca;

    @NotBlank
    private String talla;

    @NotBlank
    private double valorAlquiler;
}
