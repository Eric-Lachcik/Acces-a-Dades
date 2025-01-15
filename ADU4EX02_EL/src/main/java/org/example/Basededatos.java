package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Basededatos {

    public static void crearBaseDeDatos(String nombreBaseDatos, String usuario, String contraseña) {
        //Conexió a la base de dates
        String url = "jdbc:mysql://localhost:3307/localServer";
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
