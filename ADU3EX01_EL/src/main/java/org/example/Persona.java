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
    public void setNom(String nom) {
        this.nom = nom;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString() {
        return "PERSONA [nom=" + nom + ", edad=" + edad + ", email=" + email + "]";
    }


}
