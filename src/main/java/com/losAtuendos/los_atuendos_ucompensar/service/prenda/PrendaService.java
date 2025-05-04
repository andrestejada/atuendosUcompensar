package com.losAtuendos.los_atuendos_ucompensar.service.prenda;

import com.losAtuendos.los_atuendos_ucompensar.model.Prenda;
import com.losAtuendos.los_atuendos_ucompensar.repository.prenda.PrendaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PrendaService {

    private final PrendaRepository prendaRepository;

    public PrendaService(PrendaRepository prendaRepository) {
        this.prendaRepository = prendaRepository;
    }

    public List<Prenda> obtenerPrendaPorIds(List<Integer> ids) {
        return this.prendaRepository.obtenerPrendaPorIds(ids);
    }

    public Map<String, List<Prenda>> consultarPrendasPorTalla(String talla) {
        List<Prenda> prendas = prendaRepository.findByTalla(talla);
        if(prendas.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontraron prendas con la talla proporcionada");        }
        return prendas.stream()
                .collect(Collectors.groupingBy(prenda -> prenda.getClass().getSimpleName()));
    }

    public Prenda obtenerPrendaPorId(Integer id) {
        return this.prendaRepository.obtenerPrendaPorId(id);
    }
}
