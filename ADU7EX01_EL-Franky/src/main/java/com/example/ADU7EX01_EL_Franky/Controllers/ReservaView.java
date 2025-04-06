package com.example.ADU7EX01_EL_Franky.Controllers;

import com.example.ADU7EX01_EL_Franky.Clases.Reserva;
import com.example.ADU7EX01_EL_Franky.Repositorys.HotelRepository;
import com.example.ADU7EX01_EL_Franky.Repositorys.PersonaRepository;
import com.example.ADU7EX01_EL_Franky.Repositorys.ReservaRepository;
import com.example.ADU7EX01_EL_Franky.Repositorys.TipoHabitacionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/vistas/reservas")
public class ReservaView {
    private final ReservaRepository reservaRepository;
    private final HotelRepository hotelRepository;
    private final PersonaRepository personaRepository;
    private final TipoHabitacionRepository tipoHabitacionRepository;


    public ReservaView(ReservaRepository reservaRepository, HotelRepository hotelRepository, PersonaRepository personaRepository, TipoHabitacionRepository tipoHabitacionRepository) {
            this.reservaRepository = reservaRepository;
            this.hotelRepository = hotelRepository;
            this.personaRepository = personaRepository;
            this.tipoHabitacionRepository = tipoHabitacionRepository;
    }

    @GetMapping("/listar")
    public String listarReservas(Model model) {
        model.addAttribute("titulo", "Listado de Reservas");
        return "reservas/lista";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable Integer id, Model model) {
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Reserva no encontrada"));

        model.addAttribute("reserva", reserva);
        model.addAttribute("hoteles", hotelRepository.findAll());  // Usamos la variable de instancia
        model.addAttribute("personas", personaRepository.findAll());
        model.addAttribute("tiposHabitacion", tipoHabitacionRepository.findAll());

        return "reservas/editar";
    }

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