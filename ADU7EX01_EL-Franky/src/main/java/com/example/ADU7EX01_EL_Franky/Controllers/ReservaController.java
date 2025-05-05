package com.example.ADU7EX01_EL_Franky.Controllers;

import com.example.ADU7EX01_EL_Franky.Clases.Reserva;
import com.example.ADU7EX01_EL_Franky.Repositorys.ReservaRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    // Repositorio de reservas
    private final ReservaRepository reservaRepository;

    public ReservaController(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }
    // Obtener todas las reservas
    @GetMapping
    public List<Reserva> getAllReservas() {
        return reservaRepository.findAll();
    }
    // Obtener reservas por fecha de check-in
    @GetMapping("/checkin/{fecha}")
    public List<Reserva> getReservasByCheckIn(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {
        return reservaRepository.findByCheckIn(fecha);
    }
    // Obtener reserva por id
    @GetMapping("/{id}")
    public ResponseEntity<Reserva> getReservaById(@PathVariable Integer id) {
        Optional<Reserva> reserva = reservaRepository.findById(id);
        return reserva.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    // Crear una nueva reserva
    @PostMapping
    public Reserva createReserva(@RequestBody Reserva reserva) {
        return reservaRepository.save(reserva);
    }
    // Actualizar una reserva existente
    @PutMapping("/{id}")
    public ResponseEntity<Reserva> updateReserva(@PathVariable Integer id, @RequestBody Reserva reservaDetails) {
        return reservaRepository.findById(id).map(reserva -> {
            reserva.setCheckIn(reservaDetails.getCheckIn());
            reserva.setCheckOut(reservaDetails.getCheckOut());
            reserva.setHotel(reservaDetails.getHotel());
            reserva.setPersona(reservaDetails.getPersona());
            reserva.setNumHabitaciones(reservaDetails.getNumHabitaciones());
            reserva.setTipoHabitacion(reservaDetails.getTipoHabitacion());
            return ResponseEntity.ok(reservaRepository.save(reserva));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }
    // Eliminar una reserva
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteReserva(@PathVariable Integer id) {
        return reservaRepository.findById(id).map(reserva -> {
            reservaRepository.delete(reserva);
            return ResponseEntity.ok().build();
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
