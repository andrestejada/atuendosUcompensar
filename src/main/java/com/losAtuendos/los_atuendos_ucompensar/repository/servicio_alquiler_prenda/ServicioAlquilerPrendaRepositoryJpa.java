package com.losAtuendos.los_atuendos_ucompensar.repository.servicio_alquiler_prenda;

import com.losAtuendos.los_atuendos_ucompensar.model.ServicioAlquiler;
import com.losAtuendos.los_atuendos_ucompensar.model.ServicioAlquilerPrenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ServicioAlquilerPrendaRepositoryJpa extends JpaRepository<ServicioAlquilerPrenda,Long> {

    @Query("""
    SELECT sap 
    FROM ServicioAlquilerPrenda sap
    JOIN FETCH sap.empleado
    JOIN FETCH sap.cliente
    JOIN FETCH sap.prenda
    WHERE sap.servicioAlquiler.numero = :servicioAlquilerId
    """)
    List<ServicioAlquilerPrenda> findByServicioAlquilerId(@Param("servicioAlquilerId") Integer servicioAlquilerId);


    @Query("SELECT DISTINCT sap.servicioAlquiler " +
            "FROM ServicioAlquilerPrenda sap " +
            "WHERE sap.cliente.id = :clienteId " +
            "AND sap.servicioAlquiler.fechaAlquiler >= CURRENT_DATE " +
            "ORDER BY sap.servicioAlquiler.fechaAlquiler ASC")
    List<ServicioAlquiler> obtenerServiciosVigentesByClienteId(@Param("clienteId") Long clienteId);

    @Query("""
    SELECT sap 
    FROM ServicioAlquilerPrenda sap
    JOIN FETCH sap.empleado
    JOIN FETCH sap.cliente
    JOIN FETCH sap.prenda
    WHERE sap.servicioAlquiler.fechaAlquiler = :fechaAlquiler
""")
    List<ServicioAlquilerPrenda> findByFechaAlquiler(@Param("fechaAlquiler") LocalDate fechaAlquiler);
}
