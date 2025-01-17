package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Basededatos {

    public static void crearBaseDeDatos(String url, String nombreBaseDatos, String usuario, String contraseña) {

        String sql = "CREATE DATABASE IF NOT EXISTS " + nombreBaseDatos;

        try (Connection connection = DriverManager.getConnection(url, usuario, contraseña);

             Statement statement = connection.createStatement()) {

            // Executar comanda SQL para crear la base de dates
            statement.executeUpdate(sql);
            System.out.println("Base de datos '" + nombreBaseDatos + "' verificada o creada con éxito.");

        } catch (SQLException e) {
            System.err.println("Error al crear la base de datos: " + e.getMessage());
        }
    }
}
