package org.example;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        File xmlFile = new File("resources/llibres.xml");
        JAXBContext jaxbContext;

        try {
            jaxbContext = JAXBContext.newInstance(Llibres.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Llibres llibres = (Llibres) jaxbUnmarshaller.unmarshal(xmlFile);
            for (Llibre llibre : llibres.getLlibres()) {
                System.out.println(llibre);
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
