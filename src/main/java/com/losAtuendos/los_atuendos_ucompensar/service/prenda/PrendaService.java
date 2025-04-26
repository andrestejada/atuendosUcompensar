package com.losAtuendos.los_atuendos_ucompensar.service.prenda;

import com.losAtuendos.los_atuendos_ucompensar.model.Prenda;
import com.losAtuendos.los_atuendos_ucompensar.repository.prenda.PrendaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrendaService {

    private final PrendaRepository prendaRepository;

    public PrendaService(PrendaRepository prendaRepository) {
        this.prendaRepository = prendaRepository;
    }

    public List<Prenda> obtenerPrendaPorIds(List<Integer> ids) {
        return this.prendaRepository.obtenerPrendaPorIds(ids);
    }
}
