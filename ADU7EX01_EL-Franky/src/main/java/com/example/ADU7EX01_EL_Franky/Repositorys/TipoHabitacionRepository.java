package com.example.ADU7EX01_EL_Franky.Repositorys;

import com.example.ADU7EX01_EL_Franky.Clases.TipoHabitacion;
import org.springframework.data.jpa.repository.JpaRepository;
// Repositorio para la entidad TipoHabitacion
public interface TipoHabitacionRepository extends JpaRepository<TipoHabitacion, Integer> {
  }