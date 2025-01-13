package org.example;

import jakarta.persistence.*;

@Entity
@Table(name = "llibre")
public class Llibre {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "titol", nullable = false)
    private String titol;

    @Column(name = "anyPublicacio")
    private Integer anyPublicacio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id")
    private Autor autor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public Integer getAnyPublicacio() {
        return anyPublicacio;
    }

    public void setAnyPublicacio(Integer anyPublicacio) {
        this.anyPublicacio = anyPublicacio;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

}