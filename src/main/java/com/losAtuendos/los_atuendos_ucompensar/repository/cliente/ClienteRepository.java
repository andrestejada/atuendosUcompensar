package com.losAtuendos.los_atuendos_ucompensar.repository.cliente;

import com.losAtuendos.los_atuendos_ucompensar.model.Cliente;

public interface ClienteRepository {
    Cliente guardar(Cliente cliente);
    Cliente buscarPorId(Long id);
}
