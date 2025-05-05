package com.example.ADU7EX01_EL_Franky.Configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;

@Configuration
public class Thymeleaf {
    /**
     * Configuración de Thymeleaf para usar Java 8 Time Dialect.
     * @return Java8TimeDialect
     */
    // Se crea un bean de Java8TimeDialect para que Thymeleaf pueda manejar las fechas de Java 8
    @Bean
    public Java8TimeDialect java8TimeDialect() {
        return new Java8TimeDialect();
    }
}