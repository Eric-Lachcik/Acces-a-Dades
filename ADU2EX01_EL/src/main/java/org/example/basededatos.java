package org.example;
import java.sql.*;
import java.util.Scanner;


public class basededatos {
    private static final String url = "jdbc:sqlite:C:\\DAM2\\Acces-a-Dades\\ADU2EX01_EL\\empleados.db";;

    public static void inicializar() {
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                System.out.println();
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
                System.out.println("Mostrando Datos...");
                leerEmpleados(conn);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void insertarDatos() {
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                System.out.println("Insertando Datos...");
                insertarEmpleados(conn);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void leerEmpleados(Connection conn) {
        try (Statement stmt = conn.createStatement()) {
            String query = "SELECT * FROM empleados";
            ResultSet rs = stmt.executeQuery(query);
            System.out.println("Datos encontrados ⇊");
            while (rs.next()){
                int id = rs.getInt("id");
                String nom = rs.getString("nombre");
                int caducidad = rs.getInt("edad");
                String email = rs.getString("email");

                System.out.println("Empleado " + id + "\n -Nombre: " + nom + "\n -Edad: " + caducidad + "\n -Email: " + email);
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
            System.out.println("Tabla empleados creada correctamente.  （￣︶￣）↗　");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Tabla empleados no fue creada correctamente.");
        }
    }

    private static void insertarEmpleados(Connection conn) {
        Scanner sc = new Scanner(System.in);
        boolean agregarMas = true;

        while (agregarMas) {
            System.out.print("Ingrese ID del empleado: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Ingrese nombre del empleado: ");
            String nombre = sc.nextLine();

            System.out.print("Ingrese edad del empleado: ");
            int edad = sc.nextInt();
            sc.nextLine();

            System.out.print("Ingrese email del empleado: ");
            String email = sc.nextLine();

            String sql = "INSERT INTO empleados(id, nombre, edad, email) VALUES(?, ?, ?, ?)";

            try (PreparedStatement stat = conn.prepareStatement(sql)) {

                stat.setInt(1, id);
                stat.setString(2, nombre);
                stat.setInt(3, edad);
                stat.setString(4, email);

                stat.executeUpdate();
                System.out.println("Datos del empleado insertados correctamente. (▀̿Ĺ̯▀̿ ̿)");

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

            System.out.print("¿Desea agregar otro empleado? (s/n): ");
            String respuesta = sc.nextLine();
            agregarMas = respuesta.equalsIgnoreCase("s");
        }
    }
}
