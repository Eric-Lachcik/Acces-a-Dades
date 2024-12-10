package org.example;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2x.Exporter;
import org.hibernate.tool.hbm2x.POJOExporter;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        try {
            // Configuración de Hibernate
            Configuration cfg = new Configuration();
            cfg.configure("hibernate.cfg.xml");

            // Directorio de salida para las clases generadas
            File outputDir = new File("src/main/java");
            outputDir.mkdirs();

            // Configurar y usar POJOExporter
            Exporter exporter = new POJOExporter(cfg, outputDir);
            exporter.setOutputDirectory(outputDir);
            exporter.start();

            System.out.println("Entidades generadas en: " + outputDir.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}