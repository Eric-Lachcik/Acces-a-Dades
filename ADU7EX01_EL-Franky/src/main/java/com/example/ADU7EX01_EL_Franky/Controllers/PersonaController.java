package com.example.ADU7EX01_EL_Franky.Controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ADU7EX01_EL_Franky.Clases.Persona;
import com.example.ADU7EX01_EL_Franky.Repositorys.PersonaRepository;

@RestController
@RequestMapping("/personas")
public class PersonaController {
    // Repositorio de personas
    private final PersonaRepository personaRepository;

    public PersonaController(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }
    // Obtener todas las personas
    @GetMapping
    public List<Persona> getAllPersonas() {
        return personaRepository.findAll();
    }
    // Crear una nueva persona
    @PostMapping
    public ResponseEntity<Persona> crearPersona(@RequestBody Persona persona) {
        Persona nouPersona = personaRepository.save(persona);
        return new ResponseEntity<>(nouPersona, HttpStatus.CREATED);
    }
}
