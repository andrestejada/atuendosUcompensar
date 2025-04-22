package com.losAtuendos.los_atuendos_ucompensar.service.Prenda;

import com.losAtuendos.los_atuendos_ucompensar.model.Disfraz;
import com.losAtuendos.los_atuendos_ucompensar.model.Prenda;
import com.losAtuendos.los_atuendos_ucompensar.repository.prenda.disfraz.DisfrazRepository;
import org.springframework.stereotype.Service;

@Service
public class DisfrazService implements IPrenda{

    private final DisfrazRepository disfrazRepository;

    public DisfrazService(DisfrazRepository disfrazRepository){
        this.disfrazRepository = disfrazRepository;
    }

    @Override
    public void crear(Prenda prenda) {
        if (!(prenda instanceof Disfraz)) {
            throw new IllegalArgumentException("La prenda proporcionada no es de tipo Disfraz");
        }
        Disfraz disfraz = (Disfraz) prenda;
        this.disfrazRepository.guardar(disfraz);
    }
}
