package com.losAtuendos.los_atuendos_ucompensar.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.losAtuendos.los_atuendos_ucompensar.dto.prenda.CrearDisfrazDto;
import com.losAtuendos.los_atuendos_ucompensar.model.Disfraz;
import com.losAtuendos.los_atuendos_ucompensar.model.Prenda;
import com.losAtuendos.los_atuendos_ucompensar.service.Prenda.DisfrazFactory;
import com.losAtuendos.los_atuendos_ucompensar.service.Prenda.PrendaFactory;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/prenda")
public class PrendaController {

    private final ObjectMapper mapper;
    private final Validator validator;
    private final DisfrazFactory disfrazFactory;

    @Autowired
    public PrendaController(ObjectMapper mapper, Validator validator, DisfrazFactory disfrazFactory) {
        this.mapper = mapper;
        this.validator = validator;
        this.disfrazFactory = disfrazFactory;
    }

    @PostMapping("/{type}")
    public ResponseEntity<String> crearPrenda(@PathVariable String type, @RequestBody Map<String, Object> body) throws Exception {
        PrendaFactory prendaFactory;
        Prenda prendaParaCrear;

        switch (type.toLowerCase()) {
            case "disfraz":
                // Verificar que las propiedades requeridas estén presentes
                if (!body.containsKey("ref") || !body.containsKey("color") || !body.containsKey("talla") ||
                        !body.containsKey("valorAlquiler") || !body.containsKey("nombre")) {
                    throw new BadRequestException("faltan propiedades");
                }
                // Convert the map to CrearDisfrazDto
                CrearDisfrazDto dto = mapper.convertValue(body, CrearDisfrazDto.class);

                // Validate the DTO
                Set<ConstraintViolation<CrearDisfrazDto>> violations = validator.validate(dto);
                if (!violations.isEmpty()) {
                    throw new IllegalArgumentException("Validation failed: " + violations);
                }

                // Create the Disfraz object
                prendaParaCrear = new Disfraz(dto.getRef(), dto.getColor(), dto.getColor(), dto.getTalla(), dto.getValorAlquiler(), dto.getNombre());
                prendaFactory = disfrazFactory;
                break;
            default:
                throw new BadRequestException("Tipo de prenda no soportado");
        }

        prendaFactory.guardarPrenda(prendaParaCrear);
        return ResponseEntity.status(201).body("Prenda creada con éxito");
    }
}