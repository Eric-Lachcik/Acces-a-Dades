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

    private final TipoHabitacionRepository tipoHabitacionRepository;

    public TipoHabitacionController(TipoHabitacionRepository tipoHabitacionRepository) {
        this.tipoHabitacionRepository = tipoHabitacionRepository;
    }

    @GetMapping
    public List<TipoHabitacion> getAllTiposHabitacion() {
        return tipoHabitacionRepository.findAll();
    }


    @PostMapping
    public ResponseEntity<TipoHabitacion> crearProducte(@RequestBody TipoHabitacion tipohabitacion) {
        TipoHabitacion nouTipoHabitacion = tipoHabitacionRepository.save(tipohabitacion);
        return new ResponseEntity<>(nouTipoHabitacion, HttpStatus.CREATED);
    }
}
