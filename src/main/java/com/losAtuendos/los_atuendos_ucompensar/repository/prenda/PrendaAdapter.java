package com.losAtuendos.los_atuendos_ucompensar.repository.prenda;

import com.losAtuendos.los_atuendos_ucompensar.model.Prenda;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PrendaAdapter implements PrendaRepository{

    private final PrendaRespositoryJpa prendaRespositoryJpa;

    public PrendaAdapter(PrendaRespositoryJpa prendaRespositoryJpa) {
        this.prendaRespositoryJpa = prendaRespositoryJpa;
    }

    @Override
    public List<Prenda> obtenerPrendaPorIds(List<Integer> ids) {
        return this.prendaRespositoryJpa.findAllById(ids);
    }

    @Override
    public List<Prenda> findByTalla(String talla) {
        return this.prendaRespositoryJpa.findByTalla(talla);
    }

    @Override
    public Prenda obtenerPrendaPorId(Integer id) {
        return this.prendaRespositoryJpa.findById(id).orElse(null);
    }
}
