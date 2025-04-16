package com.losAtuendos.los_atuendos_ucompensar.repository.cliente;

import com.losAtuendos.los_atuendos_ucompensar.model.Cliente;
import com.losAtuendos.los_atuendos_ucompensar.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositoryJpa extends JpaRepository<Cliente, String> {
}

