package com.example.ADU7EX01_EL_Franky.Clases;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "persona")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "telefono", length = 50)
    private String telefono;

    @JsonIgnore
    @OneToMany(mappedBy = "persona")
    private Set<com.example.ADU7EX01_EL_Franky.Clases.Reserva> reservas = new LinkedHashSet<>();

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Set<com.example.ADU7EX01_EL_Franky.Clases.Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(Set<com.example.ADU7EX01_EL_Franky.Clases.Reserva> reservas) {
        this.reservas = reservas;
    }

}