package com.losAtuendos.los_atuendos_ucompensar.dto.prenda;


import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CrearVestidoDamaDto extends BasePrendaDto{
    @NotNull
    private Boolean pedreria;

    @NotNull
    private String altura;

    @NotNull
    private short cantPiezas;


}
