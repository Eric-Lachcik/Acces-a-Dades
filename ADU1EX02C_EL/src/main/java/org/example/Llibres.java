package org.example;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "llibres")
@XmlAccessorType(XmlAccessType.FIELD)
public class Llibres implements Serializable {

    private static final long serialVersionUID = 1L;

    @XmlElement(name = "llibre")
    private List<Llibre> llibres;

    public List<Llibre> getLlibres() {
        return llibres;
    }

    public void setLlibres(List<Llibre> llibres) {
        this.llibres = llibres;
    }

    @Override
    public String toString() {
        return "Llibres: "
                 + llibres +
                ';';
    }
}
