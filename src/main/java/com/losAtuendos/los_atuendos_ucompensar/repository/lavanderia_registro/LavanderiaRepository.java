package com.losAtuendos.los_atuendos_ucompensar.repository.lavanderia_registro;

import com.losAtuendos.los_atuendos_ucompensar.model.LavanderiaRegistro;

import java.util.List;

public interface LavanderiaRepository {
   LavanderiaRegistro guardarRegistro(LavanderiaRegistro lavanderiaRegistro);
   List<LavanderiaRegistro> obtenerTodosLosRegistros();
   List<LavanderiaRegistro> obtenerRegistrosPorEstado(String estado);
   void guardarListado(List<LavanderiaRegistro> registros);
}
