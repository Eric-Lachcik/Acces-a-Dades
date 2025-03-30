package com.example.ADU7EX01_EL_Franky.Clases;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "hotel")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cadena_id")
    @JsonIgnore
    private Cadena cadena;

    @OneToMany(mappedBy = "hotel")
    private Set<com.example.ADU7EX01_EL_Franky.Clases.Reserva> reservas = new LinkedHashSet<>();

    @OneToMany(mappedBy = "hotel")
    private Set<com.example.ADU7EX01_EL_Franky.Clases.TipoHabitacion> tipoHabitacions = new LinkedHashSet<>();

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