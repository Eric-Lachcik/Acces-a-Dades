package com.example.ADU7EX01_EL_Franky.Repositorys;

import com.example.ADU7EX01_EL_Franky.Clases.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
  }