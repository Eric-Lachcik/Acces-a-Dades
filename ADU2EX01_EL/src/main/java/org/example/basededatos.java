package org.example;
import java.sql.*;

public class basededatos {
    private static final String url = "jdbc:sqlite:C:\\DAM2\\Acces-a-Dades\\ADU2EX01_EL\\empleados.db";;

    public static void inicializar() {
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                System.out.println("Conexion Exitosa");
                createEmpleados(conn);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Conexion Fallida");
        }
    }

    public static void mostrarDatos() {
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                leerDatos(conn);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void leerDatos(Connection conn) {
        try (Statement stmt = conn.createStatement()) {
            String query = "SELECT * FROM empleados";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                int id = rs.getInt("id");
                String nom = rs.getString("nombre");
                int caducidad = rs.getInt("edad");
                String email = rs.getString("email");

                System.out.println("Empleado " + id + nom + caducidad + email);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void createEmpleados(Connection conn) {
        String sql = "CREATE TABLE IF NOT EXISTS empleados (" +
                "id INT PRIMARY KEY, " +
                "nombre VARCHAR(100) NOT NULL, " +
                "edad INT NOT NULL, " +
                "email VARCHAR(100) NOT NULL); ";

        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabla empleados creada correctamente.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Tabla empleados no fue creada correctamente.");
        }
    }

    private static void insertarDatos(Connection conn) {

    }
}
