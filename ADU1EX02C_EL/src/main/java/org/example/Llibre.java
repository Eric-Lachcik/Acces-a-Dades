package org.example;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "llibre")
@XmlAccessorType(XmlAccessType.FIELD)
public class Llibre implements Serializable {

    private static final long serialVersionUID = 1L;

    private String autor;
    private String titol;
    private Integer any;
    private String resum;

    public Llibre() {
    }

    public String getAutor() {
        return autor;
    }

    public String getTitol() {
        return titol;
    }

    public Integer getAny() {
        return any;
    }

    public String getResum() {
        return resum;
    }

    @Override
    public String toString() {
        return "Llibre{" +
                "autor: '" + autor + '\'' +
                ", titol: '" + titol + '\'' +
                ", any: " + any +
                ", resum: '" + resum + '\'' +
                '}';
    }
}
