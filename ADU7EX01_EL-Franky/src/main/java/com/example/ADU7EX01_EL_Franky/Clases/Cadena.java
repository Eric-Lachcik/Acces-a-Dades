package com.example.ADU7EX01_EL_Franky.Clases;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "cadena")
public class Cadena {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "cadena")
    private Set<com.example.ADU7EX01_EL_Franky.Clases.Hotel> hotels = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<com.example.ADU7EX01_EL_Franky.Clases.Hotel> getHotels() {
        return hotels;
    }

    public void setHotels(Set<com.example.ADU7EX01_EL_Franky.Clases.Hotel> hotels) {
        this.hotels = hotels;
    }

}