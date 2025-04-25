package com.losAtuendos.los_atuendos_ucompensar.service.prenda.vestido_dama;

import com.losAtuendos.los_atuendos_ucompensar.model.Prenda;
import com.losAtuendos.los_atuendos_ucompensar.model.VestidoDama;
import com.losAtuendos.los_atuendos_ucompensar.repository.prenda.vestido_dama.VestidoDamaRepository;
import com.losAtuendos.los_atuendos_ucompensar.service.prenda.IPrenda;
import org.springframework.stereotype.Service;

@Service
public class VestidoDamaService implements IPrenda {

    final private VestidoDamaRepository vestidoDamaRepository;

    public VestidoDamaService(VestidoDamaRepository vestidoDamaRepository) {
        this.vestidoDamaRepository = vestidoDamaRepository;
    }

    @Override
    public void crear(Prenda prenda) {
        if(!(prenda instanceof VestidoDama)){
            throw new IllegalArgumentException("El objeto no es una instancia de VestidoDama");
        }
        VestidoDama vestidoDama = (VestidoDama) prenda;
        this.vestidoDamaRepository.crear(vestidoDama);
    }
}
