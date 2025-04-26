package com.losAtuendos.los_atuendos_ucompensar.service.alquiler.builder;

import com.losAtuendos.los_atuendos_ucompensar.model.*;

public class ServicioAlquilerPrendaBuilder {
    private Long id;
    private ServicioAlquiler servicioAlquiler;
    private Prenda prenda;
    private Cliente cliente;
    private Empleado empleado;

    public ServicioAlquilerPrendaBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ServicioAlquilerPrendaBuilder conServicioAlquiler(ServicioAlquiler servicioAlquiler) {
        this.servicioAlquiler = servicioAlquiler;
        return this;
    }

    public ServicioAlquilerPrendaBuilder conPrenda(Prenda prenda) {
        this.prenda = prenda;
        return this;
    }

    public ServicioAlquilerPrendaBuilder conCliente(Cliente cliente) {
        this.cliente = cliente;
        return this;
    }

    public ServicioAlquilerPrendaBuilder conEmpleado(Empleado empleado) {
        this.empleado = empleado;
        return this;
    }

    public ServicioAlquilerPrenda build() {
        return new ServicioAlquilerPrenda(id, servicioAlquiler, prenda, cliente, empleado);
    }
}
