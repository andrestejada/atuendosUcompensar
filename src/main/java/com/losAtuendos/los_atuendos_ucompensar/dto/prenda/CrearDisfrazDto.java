package com.losAtuendos.los_atuendos_ucompensar.dto.prenda;

import com.losAtuendos.los_atuendos_ucompensar.model.Prenda;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CrearDisfrazDto extends BasePrendaDto {

    @NotBlank
    private String nombre;
}
