package com.example.ADU7EX01_EL_Franky.Repositorys;

import com.example.ADU7EX01_EL_Franky.Clases.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
// Repositorio para la entidad Persona
public interface PersonaRepository extends JpaRepository<Persona, Integer> {
  }