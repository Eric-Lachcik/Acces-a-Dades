package com.example.ADU7EX01_EL_Franky.Controllers;

import com.example.ADU7EX01_EL_Franky.Clases.TipoHabitacion;
import com.example.ADU7EX01_EL_Franky.Repositorys.TipoHabitacionRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/tipoHabitaciones")
public class TipoHabitacionController {
    // Repositorio de tipos de habitación
    private final TipoHabitacionRepository tipoHabitacionRepository;

    public TipoHabitacionController(TipoHabitacionRepository tipoHabitacionRepository) {
        this.tipoHabitacionRepository = tipoHabitacionRepository;
    }
    // Obtener todos los tipos de habitación
    @GetMapping
    public List<TipoHabitacion> getAllTiposHabitacion() {
        return tipoHabitacionRepository.findAll();
    }

    // Crear un nuevo tipo de habitación
    @PostMapping
    public ResponseEntity<TipoHabitacion> crearProducte(@RequestBody TipoHabitacion tipohabitacion) {
        TipoHabitacion nouTipoHabitacion = tipoHabitacionRepository.save(tipohabitacion);
        return new ResponseEntity<>(nouTipoHabitacion, HttpStatus.CREATED);
    }
}
