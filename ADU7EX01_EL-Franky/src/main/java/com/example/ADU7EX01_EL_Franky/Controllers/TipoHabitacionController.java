package com.example.ADU7EX01_EL_Franky.Controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ADU7EX01_EL_Franky.Clases.TipoHabitacion;
import com.example.ADU7EX01_EL_Franky.Repositorys.TipoHabitacionRepository;

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
    public ResponseEntity<TipoHabitacion> crearTipo(@RequestBody TipoHabitacion tipohabitacion) {
        TipoHabitacion nouTipoHabitacion = tipoHabitacionRepository.save(tipohabitacion);
        return new ResponseEntity<>(nouTipoHabitacion, HttpStatus.CREATED);
    }
}
