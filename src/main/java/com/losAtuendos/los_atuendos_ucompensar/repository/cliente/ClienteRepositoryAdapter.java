package com.losAtuendos.los_atuendos_ucompensar.repository.cliente;


import com.losAtuendos.los_atuendos_ucompensar.model.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteRepositoryAdapter implements  ClienteRepository{

    private final ClienteRepositoryJpa clienteRepositoryJpa;

    public ClienteRepositoryAdapter(ClienteRepositoryJpa clienteRepositoryJpa){
        this.clienteRepositoryJpa = clienteRepositoryJpa;
    }

    @Override
    public Cliente guardar(Cliente cliente) {
        Cliente newCliente = this.clienteRepositoryJpa.save(cliente);
        return newCliente;
    }

    @Override
    public Cliente buscarPorId(Long id) {
        return this.clienteRepositoryJpa.findById(id).orElse(null);
    }
}
