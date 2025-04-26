package com.losAtuendos.los_atuendos_ucompensar.service;


import com.losAtuendos.los_atuendos_ucompensar.dto.empleado.CrearEmpleadoDto;
import com.losAtuendos.los_atuendos_ucompensar.model.Empleado;
import com.losAtuendos.los_atuendos_ucompensar.repository.empleado.EmpleadosRepository;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoService {

    private final EmpleadosRepository empleadosRepository;

    public EmpleadoService(EmpleadosRepository empleadosRepository) {
        this.empleadosRepository = empleadosRepository;}

     public Empleado crearEmpleado(CrearEmpleadoDto dto){
         Empleado empleado = new Empleado(
                 null,
                    dto.getNombre(),
                    dto.getDireccion(),
                    dto.getTelefono(),
                    dto.getCargo()
         );

         return this.empleadosRepository.guardar(empleado);
    }


    public Empleado buscarEmpleadoPorId(Long id){
        return this.empleadosRepository.buscarPorId(id);
    }
}
