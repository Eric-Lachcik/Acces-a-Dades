package com.example.ADU7EX01_EL_Franky.Clases;

import java.util.LinkedHashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
// Entity TipoHabitacion
@Entity
@Table(name = "tipo_habitacion")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TipoHabitacion {
    // Id del tipo de habitacion   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    // Nombre del tipo de habitacion
    @Column(name = "nombre", nullable = false)
    private String nombre;
    // Hotel al que pertenece el tipo de habitacion
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id")
    @JsonIgnore
    private Hotel hotel;
    // Reservas del tipo de habitacion
    @JsonIgnore
    @OneToMany(mappedBy = "tipoHabitacion")
    private Set<Reserva> reservas = new LinkedHashSet<>();
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

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Set<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(Set<Reserva> reservas) {
        this.reservas = reservas;
    }

    // Metodo para obtener solo el nombre de la cadena
//    @JsonProperty("hotel")
//    public Integer getHotelNombre() {
//        return (hotel != null) ? hotel.getId() : null;
//    }
}