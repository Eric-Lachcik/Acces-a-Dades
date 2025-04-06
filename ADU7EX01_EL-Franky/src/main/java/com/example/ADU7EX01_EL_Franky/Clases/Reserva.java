package com.example.ADU7EX01_EL_Franky.Clases;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "reserva")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "check_in", nullable = false)
    @DateTimeFormat(pattern = "dd/MM/yyyy") // Formato esperado
    private LocalDate checkIn;

    @Column(name = "check_out", nullable = false)
    @DateTimeFormat(pattern = "dd/MM/yyyy") // Formato esperado
    private LocalDate checkOut;

    @Column(name = "num_habitaciones")
    private Integer numHabitaciones;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "persona_id")
    private Persona persona;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tipo_habitacion_id")
    private TipoHabitacion tipoHabitacion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Integer getNumHabitaciones() {
        return numHabitaciones;
    }

    public void setNumHabitaciones(Integer numHabitaciones) {
        this.numHabitaciones = numHabitaciones;
    }

    public com.example.ADU7EX01_EL_Franky.Clases.TipoHabitacion getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(com.example.ADU7EX01_EL_Franky.Clases.TipoHabitacion tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }
    
    // Metodo para obtener solo el nombre de la cadena
    // @JsonProperty("hotel")
    // public String getHotelNombre() {
    //     return (hotel != null) ? hotel.getNombre() : null;
    // }

    // // Metodo para obtener solo el nombre de la cadena
    // @JsonProperty("persona")
    // public String getPersonaNombre() {
    //     return (persona != null) ? persona.getNombre() : null;
    // }

    // // Metodo para obtener solo el nombre de la cadena
    // @JsonProperty("tipoHabitacion")
    // public String getHabitacionNombre() {
    //     return (tipoHabitacion != null) ? tipoHabitacion.getNombre() : null;
    // }
}