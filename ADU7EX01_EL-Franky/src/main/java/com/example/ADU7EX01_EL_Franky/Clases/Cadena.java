package com.example.ADU7EX01_EL_Franky.Clases;

import java.util.LinkedHashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
// Entity Cadena
@Entity
@Table(name = "cadena")
public class Cadena {
    // Id de la cadena
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    //  Nombre de la cadena
    @Column(name = "nombre", nullable = false)
    private String nombre;
    // Hoteles de la cadena
    @OneToMany(mappedBy = "cadena")
    private Set<com.example.ADU7EX01_EL_Franky.Clases.Hotel> hotels = new LinkedHashSet<>();
    // getters y setters
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