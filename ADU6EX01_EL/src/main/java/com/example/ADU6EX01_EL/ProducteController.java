package com.example.ADU6EX01_EL;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/productes")
public class ProducteController {
    private final ProducteRepository producteRepository;

    public ProducteController(ProducteRepository producteRepository) {
        this.producteRepository = producteRepository;
    }

    // Metodo Post para crear un producto
    @PostMapping
    public ResponseEntity<Producte> crearProducte(@RequestBody Producte producte) {
        Producte nouProducte = producteRepository.save(producte);
        return new ResponseEntity<>(nouProducte, HttpStatus.CREATED);
    }

    // Metodo Get para ver los productos
    @GetMapping
    public List<Producte> obtenirTotsProductes() {
        return producteRepository.findAll();
    }

    // Metodo Get para ver un producto en especifico
    @GetMapping("/{id}")
    public ResponseEntity<Producte> obtenirProductePerId(@PathVariable Integer id) {
        Optional<Producte> producte = producteRepository.findById(id);
        return producte.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Metodo Put para actualizar un producto
    @PutMapping("/{id}")
    public ResponseEntity<Producte> actualitzarProducte(
            @PathVariable Integer id, @RequestBody Producte producteActualitzat) {
        return producteRepository.findById(id)
                .map(producte -> {
                    producte.setNom(producteActualitzat.getNom());
                    producte.setDescripcio(producteActualitzat.getDescripcio());
                    producte.setPreu(producteActualitzat.getPreu());
                    producte.setQuantitat(producteActualitzat.getQuantitat());
                    Producte actualitzat = producteRepository.save(producte);
                    return new ResponseEntity<>(actualitzat, HttpStatus.OK);
                })
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Metodo Delete de un producto en especifico
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducte(@PathVariable Integer id) {
        if (producteRepository.existsById(id)) {
            producteRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
