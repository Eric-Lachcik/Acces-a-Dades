package com.example.ADU7EX01_EL_Franky.Repositorys;

import com.example.ADU7EX01_EL_Franky.Clases.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
// Repositorio para la entidad Hotel
public interface HotelRepository extends JpaRepository<Hotel, Integer> {
  }