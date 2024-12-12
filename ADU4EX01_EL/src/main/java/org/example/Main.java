package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:empleados.db";


        String sqlDepartaments = "CREATE TABLE IF NOT EXISTS departaments (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT NOT NULL" +
                ")";


        String sqlEmpleados = "CREATE TABLE IF NOT EXISTS empleados (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT NOT NULL," +
                "apellido TEXT NOT NULL," +
                "email TEXT," +
                "telefono TEXT)";


        String sqlProjectes = "CREATE TABLE IF NOT EXISTS projectes (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT NOT NULL," +
                "empleat_id INTEGER)";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {

            stmt.execute(sqlDepartaments);
            stmt.execute(sqlEmpleados);
            stmt.execute(sqlProjectes);
            System.out.println("Tablas creadas correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}