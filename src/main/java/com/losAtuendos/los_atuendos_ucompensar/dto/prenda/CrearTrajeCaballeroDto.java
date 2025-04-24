package com.losAtuendos.los_atuendos_ucompensar.dto.prenda;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CrearTrajeCaballeroDto extends BasePrendaDto {
    @NotNull
    private String tipo;

    @NotNull
    private String aderezo;
}
