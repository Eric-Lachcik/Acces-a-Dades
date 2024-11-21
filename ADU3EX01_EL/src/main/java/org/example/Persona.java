package org.example;
import javax.persistence.*;

@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String nom;
    private int edad;
    private String email;

    public Persona() {

    }

    public Persona(String nom, int edad, String email) {
        this.nom = nom;
        this.edad = edad;
        this.email = email;
    }

    public String getNom() {
        return nom;
    }
    public int getEdad() {
        return edad;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "PERSONA [nom=" + nom + ", edad=" + edad + ", email=" + email + "]";
    }


}
