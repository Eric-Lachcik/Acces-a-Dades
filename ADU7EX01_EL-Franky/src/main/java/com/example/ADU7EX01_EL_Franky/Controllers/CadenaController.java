package com.example.ADU7EX01_EL_Franky.Controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ADU7EX01_EL_Franky.Clases.Cadena;
import com.example.ADU7EX01_EL_Franky.Repositorys.CadenaRepository;

@RestController
@RequestMapping("/cadenas")
public class CadenaController {
    // Repositorio de cadenas
    private final CadenaRepository cadenaRepository;
    
    public CadenaController(CadenaRepository cadenaRepository) {
        this.cadenaRepository = cadenaRepository;
    }

    // Obtener todas las cadenas
    @GetMapping
    public List<Cadena> getAllCadenas() {
        return cadenaRepository.findAll();
    }

    // Crear una nueva cadena
    @PostMapping
    public ResponseEntity<Cadena> crearCadena(@RequestBody Cadena cadena) {
        Cadena nouCadena = cadenaRepository.save(cadena);
        return new ResponseEntity<>(nouCadena, HttpStatus.CREATED);
    }
}