package com.losAtuendos.los_atuendos_ucompensar.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.losAtuendos.los_atuendos_ucompensar.dto.prenda.CrearDisfrazDto;
import com.losAtuendos.los_atuendos_ucompensar.dto.prenda.CrearTrajeCaballeroDto;
import com.losAtuendos.los_atuendos_ucompensar.dto.prenda.CrearVestidoDamaDto;
import com.losAtuendos.los_atuendos_ucompensar.model.Disfraz;
import com.losAtuendos.los_atuendos_ucompensar.model.Prenda;
import com.losAtuendos.los_atuendos_ucompensar.model.TrajeCaballero;
import com.losAtuendos.los_atuendos_ucompensar.model.VestidoDama;
import com.losAtuendos.los_atuendos_ucompensar.service.prenda.PrendaFactory;
import com.losAtuendos.los_atuendos_ucompensar.service.prenda.PrendaService;
import com.losAtuendos.los_atuendos_ucompensar.service.prenda.disfraz.DisfrazFactory;
import com.losAtuendos.los_atuendos_ucompensar.service.prenda.traje_caballero.TrajeCaballeroFactory;
import com.losAtuendos.los_atuendos_ucompensar.service.prenda.vestido_dama.VestidoDamaFactory;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/prenda")
public class PrendaController {

    private final ObjectMapper mapper;
    private final Validator validator;
    private final DisfrazFactory disfrazFactory;
    private final TrajeCaballeroFactory trajeCaballeroFactory;
    private final VestidoDamaFactory vestidoDamaFactory;
    private PrendaService prendaService;

    @Autowired
    public PrendaController(ObjectMapper mapper, Validator validator, DisfrazFactory disfrazFactory, TrajeCaballeroFactory trajeCaballeroFactory, VestidoDamaFactory vestidoDamaFactory, PrendaService prendaService) {
        this.mapper = mapper;
        this.validator = validator;
        this.disfrazFactory = disfrazFactory;
        this.trajeCaballeroFactory = trajeCaballeroFactory;
        this.vestidoDamaFactory = vestidoDamaFactory;
        this.prendaService = prendaService;
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
            case "traje_caballero":
                if (!body.containsKey("ref") || !body.containsKey("color") || !body.containsKey("talla") ||
                        !body.containsKey("valorAlquiler") || !body.containsKey("marca")) {
                    throw new BadRequestException("faltan propiedades");
                }

                CrearTrajeCaballeroDto dtoTraje = mapper.convertValue(body, CrearTrajeCaballeroDto.class);

                // Validate the DTO
                Set<ConstraintViolation<CrearTrajeCaballeroDto>> violationsTraje = validator.validate(dtoTraje);
                if (!violationsTraje.isEmpty()) {
                    throw new IllegalArgumentException("Validation failed: " + violationsTraje);
                }

                // Create the TrajeCaballero object
                prendaParaCrear = new TrajeCaballero(dtoTraje.getRef(), dtoTraje.getColor(), dtoTraje.getMarca(), dtoTraje.getTalla(), dtoTraje.getValorAlquiler(), dtoTraje.getTipo(), dtoTraje.getAderezo());
                prendaFactory = trajeCaballeroFactory;
                break;
            case "vestido_dama":
                if (!body.containsKey("ref") || !body.containsKey("color") || !body.containsKey("talla") ||
                        !body.containsKey("valorAlquiler") || !body.containsKey("marca")) {
                    throw new BadRequestException("faltan propiedades");
                }

                CrearVestidoDamaDto dtoVestido = mapper.convertValue(body, CrearVestidoDamaDto.class);

                // Validate the DTO
                Set<ConstraintViolation<CrearVestidoDamaDto>> violationsVestido = validator.validate(dtoVestido);
                if (!violationsVestido.isEmpty()) {
                    throw new IllegalArgumentException("Validation failed: " + violationsVestido);
                }

                // Create the VestidoDama object
                prendaParaCrear = new VestidoDama(dtoVestido.getRef(), dtoVestido.getColor(), dtoVestido.getMarca(), dtoVestido.getTalla(), dtoVestido.getValorAlquiler(), dtoVestido.getPedreria(), dtoVestido.getAltura(), dtoVestido.getCantPiezas());
                prendaFactory = vestidoDamaFactory;
                break;
            default:
                throw new BadRequestException("Tipo de prenda no soportado");
        }

        prendaFactory.guardarPrenda(prendaParaCrear);
        return ResponseEntity.status(201).body("Prenda creada con éxito");
    }

    @GetMapping("/talla/{talla}")
    public Map<String, List<Prenda>> obtenerPrendasPorTalla(@PathVariable String talla) {
        return prendaService.consultarPrendasPorTalla(talla.toLowerCase());
    }
}