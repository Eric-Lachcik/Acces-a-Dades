package com.example.ADU7EX01_EL_Franky.Controllers;

import com.example.ADU7EX01_EL_Franky.Clases.Persona;
import com.example.ADU7EX01_EL_Franky.Repositorys.PersonaRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    private final PersonaRepository personaRepository;

    public PersonaController(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @GetMapping
    public List<Persona> getAllPersonas() {
        return personaRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Persona> crearProducte(@RequestBody Persona persona) {
        Persona nouPersona = personaRepository.save(persona);
        return new ResponseEntity<>(nouPersona, HttpStatus.CREATED);
    }
}
