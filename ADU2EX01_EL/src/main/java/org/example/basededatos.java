package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class basededatos {
    private static final String url = "jdbc:sqlite:C:\\DAM2\\ADU2EX01_EL\\empleados.db";;

    public static void inicializar() {
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                createEmpleados(conn);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void createEmpleados(Connection conn) {
        String sql = "CREATE TABLE IF NOT EXISTS empleados (" +
                "id TEXT PRIMARY KEY, " +
                "nombre TEXT NOT NULL, " +
                "apellido TEXT NOT NULL, " +
                "email TEXT NOT NULL, " +
                "telefono TEXT NOT NULL);";

        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabla empleados creada correctamente.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
