package com.example.ADU7EX01_EL_Franky.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ADU7EX01_EL_Franky.Clases.Reserva;
import com.example.ADU7EX01_EL_Franky.Repositorys.HotelRepository;
import com.example.ADU7EX01_EL_Franky.Repositorys.PersonaRepository;
import com.example.ADU7EX01_EL_Franky.Repositorys.ReservaRepository;
import com.example.ADU7EX01_EL_Franky.Repositorys.TipoHabitacionRepository;

@Controller
@RequestMapping("/vistas/reservas")
public class ReservaView {
    // Repositorios de reservas, hoteles, personas y tipos de habitación
    private final ReservaRepository reservaRepository;
    private final HotelRepository hotelRepository;
    private final PersonaRepository personaRepository;
    private final TipoHabitacionRepository tipoHabitacionRepository;

    // Constructor para inyectar los repositorios
    public ReservaView(ReservaRepository reservaRepository, HotelRepository hotelRepository, PersonaRepository personaRepository, TipoHabitacionRepository tipoHabitacionRepository) {
            this.reservaRepository = reservaRepository;
            this.hotelRepository = hotelRepository;
            this.personaRepository = personaRepository;
            this.tipoHabitacionRepository = tipoHabitacionRepository;
    }

    // Métodos para manejar las vistas de reservas
    @GetMapping("/listar")
    public String listarReservas(Model model) {
        model.addAttribute("titulo", "Listado de Reservas");
        return "reservas/lista";
    }
    // Método para mostrar el formulario de edición de reservas
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable Integer id, Model model) {
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Reserva no encontrada"));

        model.addAttribute("reserva", reserva);
        model.addAttribute("hoteles", hotelRepository.findAll());  
        model.addAttribute("personas", personaRepository.findAll());
        model.addAttribute("tiposHabitacion", tipoHabitacionRepository.findAll());

        return "reservas/editar";
    }
    // Método para actualizar la reserva en el formulario de edición
    @PutMapping("/editar/{id}")
    public String actualizarReserva(@PathVariable Integer id, @ModelAttribute Reserva reservaActualizada) {
        reservaRepository.findById(id).ifPresent(reserva -> {
            reserva.setCheckIn(reservaActualizada.getCheckIn());
            reserva.setCheckOut(reservaActualizada.getCheckOut());
            reserva.setNumHabitaciones(reservaActualizada.getNumHabitaciones());
            reserva.setHotel(reservaActualizada.getHotel());
            reserva.setPersona(reservaActualizada.getPersona());
            reserva.setTipoHabitacion(reservaActualizada.getTipoHabitacion());

            reservaRepository.save(reserva);
        });
        return "redirect:/vistas/reservas/listar";
    }
}