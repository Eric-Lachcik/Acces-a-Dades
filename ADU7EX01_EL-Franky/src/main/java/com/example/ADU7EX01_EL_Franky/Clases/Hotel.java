package com.example.ADU7EX01_EL_Franky.Clases;

import java.util.LinkedHashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

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
// Entity Hotel
@Entity
@Table(name = "hotel")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Hotel {
    // Id del Hotel
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    // Nombre del Hotel
    @Column(name = "nombre", nullable = false)
    private String nombre;
    // Cadena a la que pertenece el Hotel
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cadena_id")
    private Cadena cadena;
    // Reservas del Hotel
    @JsonIgnore
    @OneToMany(mappedBy = "hotel")
    private Set<com.example.ADU7EX01_EL_Franky.Clases.Reserva> reservas = new LinkedHashSet<>();
    // Habitaciones del Hotel
    @JsonIgnore
    @OneToMany(mappedBy = "hotel")
    private Set<com.example.ADU7EX01_EL_Franky.Clases.TipoHabitacion> tipoHabitacions = new LinkedHashSet<>();
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

    public Cadena getCadena() {
        return cadena;
    }

    public void setCadena(Cadena cadena) {
        this.cadena = cadena;
    }

    public Set<com.example.ADU7EX01_EL_Franky.Clases.Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(Set<com.example.ADU7EX01_EL_Franky.Clases.Reserva> reservas) {
        this.reservas = reservas;
    }

    public Set<com.example.ADU7EX01_EL_Franky.Clases.TipoHabitacion> getTipoHabitacions() {
        return tipoHabitacions;
    }

    public void setTipoHabitacions(Set<com.example.ADU7EX01_EL_Franky.Clases.TipoHabitacion> tipoHabitacions) {
        this.tipoHabitacions = tipoHabitacions;
    }

    // Metodo para obtener solo el nombre de la cadena
    @JsonProperty("cadena")
    public String getCadenaNombre() {
        return (cadena != null) ? cadena.getNombre() : null;
    }
}