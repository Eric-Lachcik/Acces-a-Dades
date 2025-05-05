package com.example.ADU7EX01_EL_Franky.Repositorys;

import com.example.ADU7EX01_EL_Franky.Clases.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
// Repositorio para la entidad Reserva
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
  // Método para buscar reservas por fecha de check-in
  @Query("SELECT r FROM Reserva r WHERE r.checkIn = :fechaCheckIn")
  List<Reserva> findByCheckIn(@Param("fechaCheckIn") LocalDate checkIn);
}