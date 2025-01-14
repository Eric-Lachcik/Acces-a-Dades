package org.example;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.List;
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
                    System.out.println("Datos de autor insertados correctamente. " + autor.getNom());
                } catch (Exception e) {
                    transaction.rollback();
                    System.err.println("Error al insertar datos de autor: " + e.getMessage());
                    e.printStackTrace();
                }

                System.out.print("¿Desea agregar otro autor? (s/n): ");
                String respuesta = scAgr.nextLine();
                agregarMas = respuesta.equalsIgnoreCase("s");


            }
        }
    }

    public static void crearLlibre(Scanner sc) {
        try (Session session = hibernate.getSessionFactory().openSession()){
            // Verificar si hay al menos un autor registrado en la base de datos
            Query<Long> countQuery = session.createQuery("SELECT COUNT(a) FROM Autor a", Long.class);
            Long totalAutores = countQuery.uniqueResult();

            if (totalAutores == 0) {
                System.out.println("No hay autores registrados");
            } else {
                Scanner scAgr = new Scanner(System.in);
                boolean agregarMas = true;
                while (agregarMas) {
                    try  {
                        Transaction transaction = session.beginTransaction();

                        System.out.print("Introdueix el títol del llibre: ");
                        String titol = sc.nextLine();

                        System.out.print("Introdueix l'any de publicació: ");
                        int anyPublicacio = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Introdueix l'ID de l'autor del llibre: ");
                        int autorId = sc.nextInt();
                        sc.nextLine();

                        Autor autor = session.get(Autor.class, autorId);
                        if (autor == null) {
                            System.out.println("Autor no trobat.");
                            return;
                        }

                        Llibre llibre = new Llibre();
                        llibre.setTitol(titol);
                        llibre.setAnyPublicacio(anyPublicacio);
                        llibre.setAutor(autor);

                        // Guardar libro
                        session.persist(llibre);

                        try {
                            transaction.commit();
                            System.out.println("Datos del libro insertados correctamente. " + llibre.getTitol());
                        } catch (Exception e) {
                            transaction.rollback();
                            System.err.println("Error al insertar datos del libro: " + e.getMessage());
                            e.printStackTrace();
                        }

                        System.out.print("¿Desea agregar otro libro? (s/n): ");
                        String respuesta = scAgr.nextLine();
                        agregarMas = respuesta.equalsIgnoreCase("s");

                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public static void leerDatos() {
        try (Session session = hibernate.getSessionFactory().openSession()) {
            // Consulta para obtener todos los autores
            List<Autor> autores = session.createQuery("FROM Autor", Autor.class).list();

            if (autores.isEmpty()) {
                System.out.println("No hay autores registrados.");
            } else {
                System.out.println("Lista de autores y sus libros:");
                for (Autor autor : autores) {
                    System.out.println("Autor: " + autor.getNom() + " (ID: " + autor.getId() + ")");
                    if (autor.getLlibres().isEmpty()) {
                        System.out.println("  Este autor no tiene libros registrados.");
                    } else {
                        autor.getLlibres().forEach(llibre ->
                                System.out.println("  Llibre: " + llibre.getTitol() + ", Any: " + llibre.getAnyPublicacio())
                        );
                    }
                }
            }

            // Consulta para obtener todos los libros
            List<Llibre> llibres = session.createQuery("FROM Llibre", Llibre.class).list();

            if (llibres.isEmpty()) {
                System.out.println("\nNo hay libros registrados.");
            } else {
                System.out.println("\nLista de libros:");
                for (Llibre llibre : llibres) {
                    System.out.println("Llibre: " + llibre.getTitol() + ", Any: " + llibre.getAnyPublicacio());
                    if (llibre.getAutor() != null) {
                        System.out.println("  Autor: " + llibre.getAutor().getNom());
                    } else {
                        System.out.println("  Este libro no tiene autor asignado.");
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error al leer datos del libro: " + e.getMessage());
            throw new RuntimeException(e);

        }
    }

    public static void modificarDatosLlibre(Scanner sc) {
        try (Session session = hibernate.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();


            System.out.print("Ingrese el ID del llibre que desea modificar: ");
            int llibreId = sc.nextInt();
            sc.nextLine();

            Llibre llibre = session.get(Llibre.class, llibreId);
            if (llibre != null) {
                System.out.println("Libro encontrado: " + llibre.getTitol() + " (" + llibre.getAnyPublicacio() + ")");

                // Solicitar el nuevo título (opcional)
                System.out.print("Ingrese el nuevo título del llibre (deje vacío para no modificar): ");
                String nuevoTitulo = sc.nextLine();
                if (!nuevoTitulo.trim().isEmpty()) {
                    llibre.setTitol(nuevoTitulo);
                }

                // Solicitar el nuevo año de publicación (opcional)
                System.out.print("Ingrese el nuevo año de publicación (deje vacío para no modificar): ");
                String nuevoAnyStr = sc.nextLine();
                if (!nuevoAnyStr.trim().isEmpty()) {
                    try {
                        int nuevoAny = Integer.parseInt(nuevoAnyStr);
                        llibre.setAnyPublicacio(nuevoAny);
                    } catch (NumberFormatException e) {
                        System.out.println("El año ingresado no es válido. No se modificará el año de publicación.");
                    }
                }

                // Confirmar cambios al usuario
                System.out.println("¿Desea guardar los cambios? (s/n): ");
                String confirmacion = sc.nextLine();
                if (confirmacion.equalsIgnoreCase("s")) {
                    session.merge(llibre);
                    transaction.commit();
                    System.out.println("Llibre modificado correctamente.");
                } else {
                    System.out.println("Cambios cancelados.");
                    transaction.rollback();
                }
            } else {
                System.out.println("Llibre no encontrado.");
            }
        }
    }

    public static void eliminarLlibre(Scanner sc) {
        try (Session session = hibernate.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            System.out.print("Introdueix l'ID de l'autor del llibre: ");
            int llibreId = sc.nextInt();
            sc.nextLine();

            Llibre llibre = session.get(Llibre.class, llibreId);
            if (llibre != null) {
                // Eliminamos el libro
                session.remove(llibre);
                transaction.commit();
                System.out.println("Llibre eliminado correctamente.");

                // Verificamos si el libro ha sido eliminado
                Llibre libroVerificado = session.get(Llibre.class, llibreId);
                if (libroVerificado == null) {
                    System.out.println("La eliminación se verificó correctamente.");
                } else {
                    System.out.println("Error: El llibre aún existe en la base de datos.");
                }
            } else {
                System.out.println("Llibre no encontrado.");
            }
        }
    }

    public static void eliminarAutor(Scanner sc) {
        try (Session session = hibernate.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            System.out.print("Introdueix l'ID de l'autor del llibre: ");
            int autorId = sc.nextInt();
            sc.nextLine();

            Autor autor = session.get(Autor.class, autorId);
            if (autor != null) {
                // Eliminamos el autor
                session.remove(autor);
                transaction.commit();
                System.out.println("Autor eliminado correctamente.");

                // Verificamos si el autor ha sido eliminado
                Autor autorVerificado = session.get(Autor.class, autorId);
                if (autorVerificado == null) {
                    System.out.println("La eliminación del autor se verificó correctamente.");

                    // Verificamos si los libros relacionados también fueron eliminados
                    List<Llibre> llibresRelacionados = session.createQuery(
                                    "FROM Llibre WHERE autor.id = :autorId", Llibre.class)
                            .setParameter("autorId", autorId)
                            .list();
                    if (llibresRelacionados.isEmpty()) {
                        System.out.println("Todos los libros relacionados con el autor fueron eliminados correctamente.");
                    } else {
                        System.out.println("Error: Hay libros que aún están relacionados con el autor eliminado.");
                    }
                } else {
                    System.out.println("Error: El autor aún existe en la base de datos.");
                }
            } else {
                System.out.println("Autor no encontrado.");
            }
        }
    }
}
