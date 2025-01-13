package org.example;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.util.Scanner;

public class Metodos {

    public static void insertarDatosAutor(Scanner sc) {
        Scanner scAgr = new Scanner(System.in);
        boolean agregarMas = true;
        while (agregarMas) {
            try (Session session = hibernate.getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();

                sc.nextLine();
                // Validación de campo nombre.
                String nom = "";
                while (!nom.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
                    System.out.print("Ingrese nombre del empleado (solo letras y espacios): ");
                    nom = sc.nextLine();
                    if (!nom.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
                        System.out.println("El nombre solo puede contener letras y espacios.");
                    }
                }

                sc.nextLine();
                String dataNaixement = "";
                // Validación de campo Fecha.
                while (!dataNaixement.matches("^\\d{4}-\\d{2}-\\d{2}$")) {
                    System.out.print("Ingrese la fecha (formato YYYY-MM-DD): ");
                    dataNaixement = sc.nextLine();
                    if (!dataNaixement.matches("^\\d{4}-\\d{2}-\\d{2}$")) {
                        System.out.println("Por favor, ingrese una fecha válida en el formato YYYY-MM-DD.");
                    }
                }

                Autor autor = new Autor();
                autor.setNom(nom);
                autor.setDataNaixement(LocalDate.parse(dataNaixement));

                // Persistir autor
                session.persist(autor);

                try {
                    transaction.commit();
                    System.out.println("Datos de autor insertados correctamente.");
                } catch (Exception e) {
                    transaction.rollback();
                    System.err.println("Error al insertar datos de autor: " + e.getMessage());
                    e.printStackTrace();
                }

                System.out.print("¿Desea agregar otro autor? (s/n): ");
                String respuesta = scAgr.nextLine();
                agregarMas = respuesta.equalsIgnoreCase("s");

                // Crear libro asociado
                Llibre llibre = new Llibre();
                llibre.setTitol("Llibre 1");
                llibre.setAnyPublicacio(2020);
                llibre.setAutor(autor);

                // Guardar libro
                session.persist(llibre);

            }
        }
    }

    public static void leerDatos() {
        try (Session session = hibernate.getSessionFactory().openSession()) {
            Autor autor = session.get(Autor.class, 1);
            if (autor != null) {
                System.out.println("Autor: " + autor.getNom());
                autor.getLlibres().forEach(llibre ->
                        System.out.println("Llibre: " + llibre.getTitol() + ", Any: " + llibre.getAnyPublicacio())
                );
            } else {
                System.out.println("Autor no encontrado.");
            }
        }
    }

    public static void modificarDatosLlibre(int llibreId, String nuevoTitulo) {
        try (Session session = hibernate.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            Llibre llibre = session.get(Llibre.class, llibreId);
            if (llibre != null) {
                llibre.setTitol(nuevoTitulo);
                session.update(llibre);
                transaction.commit();
                System.out.println("Llibre modificado correctamente.");
            } else {
                System.out.println("Llibre no encontrado.");
            }
        }
    }

    public static void eliminarLlibre(int llibreId) {
        try (Session session = hibernate.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            Llibre llibre = session.get(Llibre.class, llibreId);
            if (llibre != null) {
                session.remove(llibre);
                transaction.commit();
                System.out.println("Llibre eliminado correctamente.");
            } else {
                System.out.println("Llibre no encontrado.");
            }
        }
    }

    public static void eliminarAutor(int autorId) {
        try (Session session = hibernate.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            Autor autor = session.get(Autor.class, autorId);
            if (autor != null) {
                session.remove(autor);
                transaction.commit();
                System.out.println("Autor y libros asociados eliminados correctamente.");
            } else {
                System.out.println("Autor no encontrado.");
            }
        }
    }

}
