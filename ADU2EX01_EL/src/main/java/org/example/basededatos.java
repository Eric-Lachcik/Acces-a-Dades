package org.example;
import java.sql.*;
import java.util.Scanner;


public class basededatos {
    //Url a modificar segun el sitio de creacion de la base datos.
    private static final String url = "jdbc:sqlite:C:\\DAM2\\Acces-a-Dades\\ADU2EX01_EL\\empleados.db";

    //Metodo encargado de llamar al metodo privado que se encarga de llamar al metodo que crea la tabla empleados.
    public static boolean inicializar() {
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                System.out.println();
                System.out.println("Conexion Exitosa");
                createEmpleados(conn);
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Conexion Fallida");
        }
        return false;
    }

    //Metodo encargado de llamar al metodo privado que se encarga de leer y mostrar los datos por las terminal.
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

    //Metodo encargado de llamar al metodo privado que se encarga de insertar nuevos empleados
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

    //Metodo el cual contiene la logica que se  encarga de leer los datos.
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

                System.out.println("Empleado con el Id:" + id + "\n -Nombre: " + nom + "\n -Edad: " + caducidad + "\n -Email: " + email);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //Metodo que se encarga de crear la tabla empleados para la base de datos.
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

    //Metodo que se encarga de la logica dentras de insertar los empleados en la base de datos.
    private static void insertarEmpleados(Connection conn) {
        Scanner sc = new Scanner(System.in);
        boolean agregarMas = true;
        //While para añadir la opcion de agregar mas empleados despues de agregar a uno.
        while (agregarMas) {
            int id = -1;
            //Validacion de campo Id
            while (id < 0) {
                System.out.print("Ingrese ID del empleado (solo números positivos): ");
                if (sc.hasNextInt()) {
                    id = sc.nextInt();
                    if (id < 0) {
                        System.out.println("El ID debe ser un número positivo.");
                    }
                } else {
                    System.out.println("Por favor, ingrese un número válido.");
                    sc.next();
                }
            }
            sc.nextLine();
            //Validacion de campo nombre
            String nombre = "";
            while (!nombre.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
                System.out.print("Ingrese nombre del empleado (solo letras y espacios): ");
                nombre = sc.nextLine();
                if (!nombre.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
                    System.out.println("El nombre solo puede contener letras y espacios.");
                }
            }

            int edad = -1;
            //Validacion de campo edad
            while (edad < 0) {
                System.out.print("Ingrese edad del empleado (solo números positivos): ");
                if (sc.hasNextInt()) {
                    edad = sc.nextInt();
                    if (edad < 0) {
                        System.out.println("La edad debe ser un número positivo.");
                    }
                } else {
                    System.out.println("Por favor, ingrese un número válido.");
                    sc.next();
                }
            }
            sc.nextLine();

            String email = "";
            //Validacion de campo Email, tiene que contener el @
            while (!email.matches("^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
                System.out.print("Ingrese email del empleado (formato válido): ");
                email = sc.nextLine();
                if (!email.matches("^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
                    System.out.println("Por favor, ingrese un email válido.");
                }
            }

            String sql = "INSERT INTO empleados(id, nombre, edad, email) VALUES(?, ?, ?, ?)";
            //Try/Catch encargado de insertar los datos del empleado
            try (PreparedStatement stat = conn.prepareStatement(sql)) {
                stat.setInt(1, id);
                stat.setString(2, nombre);
                stat.setInt(3, edad);
                stat.setString(4, email);

                stat.executeUpdate();
                System.out.println("Datos del empleado insertados correctamente. ヾ(≧▽≦*)o");
            } catch (SQLException e) {
                System.out.println("Error al insertar los datos: " + e.getMessage());
            }

            System.out.print("¿Desea agregar otro empleado? (s/n): ");
            String respuesta = sc.nextLine();
            agregarMas = respuesta.equalsIgnoreCase("s");
        }
    }
}
