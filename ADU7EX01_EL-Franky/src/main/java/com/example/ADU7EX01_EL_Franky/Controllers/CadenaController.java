package com.example.ADU7EX01_EL_Franky.Controllers;

import com.example.ADU7EX01_EL_Franky.Clases.Cadena;
import com.example.ADU7EX01_EL_Franky.Repositorys.CadenaRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/cadenas")
public class CadenaController {

    private final CadenaRepository cadenaRepository;

    public CadenaController(CadenaRepository cadenaRepository) {
        this.cadenaRepository = cadenaRepository;
    }

    // Obtener todas las cadenas
    @GetMapping
    public List<Cadena> getAllCadenas() {
        return cadenaRepository.findAll();
    }


    @PostMapping
    public ResponseEntity<Cadena> crearProducte(@RequestBody Cadena cadena) {
        Cadena nouCadena = cadenaRepository.save(cadena);
        return new ResponseEntity<>(nouCadena, HttpStatus.CREATED);
    }
}