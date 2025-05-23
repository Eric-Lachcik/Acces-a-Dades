package com.example.ADU7EX01_EL_Franky.Controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ADU7EX01_EL_Franky.Clases.Hotel;
import com.example.ADU7EX01_EL_Franky.Repositorys.HotelRepository;

@RestController
@RequestMapping("/hoteles")
public class HotelController {
    // Repositorio de hoteles
    private final HotelRepository hotelRepository;

    public HotelController(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }
    // Obtener todos los hoteles
    @GetMapping
    public List<Hotel> getAllHoteles() {
        return hotelRepository.findAll();
    }
    // Crear un nuevo hotel
    @PostMapping
    public ResponseEntity<Hotel> crearHotel(@RequestBody Hotel hotel) {
        Hotel nouHotel = hotelRepository.save(hotel);
        return new ResponseEntity<>(nouHotel, HttpStatus.CREATED);
    }
}